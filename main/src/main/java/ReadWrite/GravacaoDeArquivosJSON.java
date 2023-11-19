package ReadWrite;

import Atendimento.Atendimento;
import Equipe.Equipe;
import Manage.ACMERescue;
import ReadWrite.JSONTypes.EquipamentoTypeFactory;
import ReadWrite.JSONTypes.EventoTypeFactory;
import ReadWrite.JSONTypes.TipoAtendimento;
import ReadWrite.JSONTypes.TipoEquipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravacaoDeArquivosJSON {
    
    private String nomeArquivo;
    private ACMERescue acme;
    
    public GravacaoDeArquivosJSON(String nomeArquivo, ACMERescue acme) {
        this.nomeArquivo = nomeArquivo;
        this.acme = acme;
        writeAll();
    }
    
    public void writeAll() {
        escreverEquipeJson();
        escreverAtendimentoJson();
        escreverEquipamento();
        escreverEvento();
    }
    
    private void escreverEquipeJson() {
        File file = new File("ReadWrite/ESCRITA/JSON/" + nomeArquivo + "-EQUIPES-JSON.json");
        try{if(!file.exists()) file.createNewFile();}catch(IOException e) {}
        
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Equipe.class, new TipoEquipe())
                .create();
        String json = gson.toJson(acme.retornaListaEquipe());
        try {
            try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            }
        }catch(IOException e) {}
    }
    
    private void escreverAtendimentoJson() {
        File file = new File("ReadWrite/ESCRITA/JSON/" + nomeArquivo + "-ATENDIMENTOS-JSON.json");
        try {if(!file.exists()) file.createNewFile();} catch (IOException e) {}
        Gson gson = new GsonBuilder().registerTypeAdapter(Atendimento.class, new TipoAtendimento()).create();
        String json = gson.toJson(acme.retornaListaAtendimento());
        try{
            try(FileWriter writer = new FileWriter(file)) {
                writer.write(json);
            }
        } catch(IOException e) {}
    }
    

    
    private void escreverEquipamento() {
        File file = new File("ReadWrite/ESCRITA/JSON/" + nomeArquivo + "-EQUIPAMENTOS-JSON.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new EquipamentoTypeFactory())
                .create();
        String json = gson.toJson(acme.retornaListaEquipamento());

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void escreverEvento() {
        File file = new File("ReadWrite/ESCRITA/JSON/" + nomeArquivo + "-EVENTOS-JSON.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new EventoTypeFactory())
                .create();
        String json = gson.toJson(acme.retornaListaEvento());

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}























