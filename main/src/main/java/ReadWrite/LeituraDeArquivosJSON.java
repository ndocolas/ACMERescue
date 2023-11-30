package ReadWrite;

import Atendimento.Atendimento;
import Equipamentos.Tipos.Barco;
import Equipamentos.Tipos.CaminhaoTanque;
import Equipamentos.Tipos.Escavadeira;
import Equipe.Equipe;
import Eventos.Evento;
import Eventos.Tipos.Ciclone;
import Eventos.Tipos.Seca;
import Eventos.Tipos.Terremoto;
import Manage.ACMERescue;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class LeituraDeArquivosJSON {
    
    private ACMERescue acme;
    private String arquivoJson;
    private JTextArea jta;
    
    public LeituraDeArquivosJSON(String arquivoJson, ACMERescue acme, JTextArea jta) {
        this.acme = acme;
        this.arquivoJson = arquivoJson;
        this.jta = jta;
        readAll();
    }
    
    private void readAll() {
        lerEquipesJson();
        lerEventosJson();
        lerAtendimentosJson();
        lerEquipamentosJson();
    }
    
    public void lerEquipesJson() {
        File file = new File("ReadWrite/" + arquivoJson + "-EQUIPES-JSON.json");
        if (!file.exists()) {
            jta.append("\nArquivo " + arquivoJson + "-EQUIPES-JSON.json inexistsente");
            return;
        }
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for(JsonElement e : jsonArray) {
                acme.adicionarEquipe(gson.fromJson(e,Equipe.class));
            }
        } catch (IOException e) {}
    }   
    
    public void lerAtendimentosJson() {
        File file = new File("ReadWrite/" + arquivoJson + "-ATENDIMENTOS-JSON.json");
        if (!file.exists()) {
            jta.append("\nArquivo "+ arquivoJson + "-ATENDIMENTOS-JSON.json inexistsente");
            return;
        }
        
        try (FileReader reader = new FileReader(file)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for(JsonElement e : jsonArray) {
                int codigo = e.getAsJsonObject().get("codigo").getAsInt();
                String data = e.getAsJsonObject().get("dataInicio").getAsString();
                int duracao = e.getAsJsonObject().get("duracao").getAsInt();
                Evento codigoEvento = acme.pesquisarCodigoEvento(e.getAsJsonObject().get("evento").getAsString());
                Equipe equipe = null;
                try {
                    equipe = acme.pesquisarCodigoEquipe(e.getAsJsonObject().get("equipe").getAsString());
                } catch(Exception ex) {}
                if(equipe == null) acme.adicionarAtendimento(new Atendimento(codigo, data, duracao, codigoEvento));
                else  acme.adicionarAtendimento(new Atendimento(codigo, data, duracao, codigoEvento, equipe));
            }
        } catch (IOException e) {}
    }
    
    public void lerEventosJson() {
        File file = new File("ReadWrite/" + arquivoJson + "-EVENTOS-JSON.json");
        if (!file.exists()) {
            jta.append("\nArquivo "+ arquivoJson + "-EVENTOS-JSON.json inexistsente");
            return;
        }
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(file)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement jsonElement : jsonArray) {
                int tipo = jsonElement.getAsJsonObject().get("tipo").getAsInt();

                switch (tipo) {
                    case 1:
                        acme.adicionarEvento(gson.fromJson(jsonElement, Ciclone.class));
                        break;
                    case 2:
                        acme.adicionarEvento(gson.fromJson(jsonElement, Terremoto.class));
                        break;
                    case 3:
                        acme.adicionarEvento(gson.fromJson(jsonElement, Seca.class));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {}

    }
    
    private void lerEquipamentosJson() {
        File file = new File("ReadWrite/" + arquivoJson + "-EQUIPAMENTOS-JSON.json");
        if (!file.exists()) {
            jta.append("\nArquivo "+ arquivoJson + "-EQUIPAMENTOS-JSON.json inexistsente");
            return;
        }
        
        try (FileReader reader = new FileReader(file)){
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement e : jsonArray) {
                int id = e.getAsJsonObject().get("identificador").getAsInt();
                String nome = e.getAsJsonObject().get("nome").getAsString();
                Equipe equipe = acme.pesquisarCodigoEquipe(e.getAsJsonObject().get("equipe").getAsString());
                double custoDiario = e.getAsJsonObject().get("custoDiario").getAsDouble();
                int tipo = e.getAsJsonObject().get("tipo").getAsInt();
                switch(tipo) {
                    case 1 -> {
                        int cap = e.getAsJsonObject().get("capacidade").getAsInt();
                        acme.adicionarEquipamento(new Barco(id, nome, custoDiario, cap, equipe));
                    }
                    case 2 -> {
                        double cap = e.getAsJsonObject().get("capacidade").getAsDouble();
                        acme.adicionarEquipamento(new CaminhaoTanque(id, nome, custoDiario, cap, equipe));
                    }
                    case 3 -> {
                        String combustivel = e.getAsJsonObject().get("combustivel").getAsString();
                        double carga = e.getAsJsonObject().get("carga").getAsDouble();
                        acme.adicionarEquipamento(new Escavadeira(id, nome, custoDiario, combustivel, carga, equipe));
                    }
                }
            }
            
            
        }catch(IOException e) {}
    }
}
