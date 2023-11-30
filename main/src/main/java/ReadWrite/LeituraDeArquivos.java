package ReadWrite;

import Atendimento.Atendimento;
import Equipamentos.Tipos.Barco;
import Equipamentos.Tipos.CaminhaoTanque;
import Equipamentos.Tipos.Escavadeira;
import Equipe.Equipe;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextArea;

import Manage.ACMERescue;
import Eventos.Tipos.Ciclone;
import Eventos.Tipos.Seca;
import Eventos.Tipos.Terremoto;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LeituraDeArquivos {
    
    private ACMERescue acmeRescue;
    private String nomeArq;
    private JTextArea jta;

    public LeituraDeArquivos(String arquivo, ACMERescue acmerescue, JTextArea jta) {
        this.acmeRescue = acmerescue;
        nomeArq=arquivo;
        this.jta = jta;
        readAll();
    }
    
    private void readAll() {
        readEvento();
        readEquipe();
        readAtendimento();
        readEquipamento();
    }
    
    private void readEvento() {
        File arquivo = new File("ReadWrite/" + nomeArq + "-EVENTOS.csv");
        
        if (!arquivo.exists()) {
            jta.append("\nArquivo " + nomeArq + "-EVENTOS.csv inexistsente");
            return;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            String linha;
            br.readLine();
            while((linha = br.readLine()) != null) {
                try {
                Scanner sc = new Scanner(linha).useDelimiter("[;]");
                String codigo = sc.next();
                String data = sc.next();
                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();
                int tipo = sc.nextInt();
                double valor = sc.nextDouble();
                   switch(tipo) {
                       case 1 -> {
                           acmeRescue.adicionarEvento(new Ciclone(codigo, data, latitude, longitude, valor, sc.nextDouble()));
                       }
                       case 2 -> {
                           acmeRescue.adicionarEvento(new Terremoto(codigo, data, latitude, longitude, valor));
                       }
                       case 3 -> {
                           acmeRescue.adicionarEvento(new Seca(codigo, data, latitude, longitude, (int) valor));
                       }
                       default -> {break;}
                   }
                   sc.close();
                } catch(InputMismatchException exception) {
                    System.out.println("Dados invalidos EVENTO");}
                
            }
        }catch(IOException | NoSuchElementException e) {}
    }
    
    private void readAtendimento() {
        File arquivo = new File("ReadWrite/" + nomeArq + "-ATENDIMENTOS.csv");
        
        if (!arquivo.exists()) {
            jta.append("\nArquivo  " + nomeArq + "-ATENDIMENTOS.csv inexistsente");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();
            while((linha = br.readLine()) != null) {
                try {
                Scanner sc = new Scanner(linha).useDelimiter("[;]");
                int codigo = sc.nextInt();
                String dataInicio = sc.next();
                int duracao = sc.nextInt();
                String codigoEvento = sc.next();
                if(sc.hasNext()) {
                Equipe equipe = null;
                try{
                    equipe = acmeRescue.pesquisarCodigoEquipe(sc.next());
                } catch(NullPointerException e1) {}
                acmeRescue.adicionarAtendimento(new Atendimento(codigo, dataInicio, duracao, acmeRescue.pesquisarCodigoEvento(codigoEvento), equipe));
                } else acmeRescue.adicionarAtendimento(new Atendimento(codigo, dataInicio, duracao, acmeRescue.pesquisarCodigoEvento(codigoEvento)));
                     
                
                sc.close();
                } catch (InputMismatchException e) {e.printStackTrace();}
            }   
        } catch(Exception e) {e.printStackTrace();}
    }
    
    private void readEquipamento() {
        File arquivo = new File("ReadWrite/" + nomeArq + "-EQUIPAMENTOS.csv");
        
        if (!arquivo.exists()) {
            jta.append("\nArquivo  " + nomeArq + "-EQUIPAMENTOS.csv inexistsente");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();
            while((linha = br.readLine()) != null) {
                try {
                Scanner sc = new Scanner(linha.trim()).useDelimiter("[;]");
                int id = sc.nextInt();
                String nome = sc.next();
                double custodiario = sc.nextDouble();
                Equipe equipe = acmeRescue.pesquisarCodigoEquipe(sc.next());
                if(equipe == null) continue;
                int tipo = sc.nextInt();
                switch(tipo) {
                    case 1 -> {
                        acmeRescue.adicionarEquipamento(new Barco(id, nome, custodiario, sc.nextInt(), equipe));
                        }
                    case 2 -> {
                        acmeRescue.adicionarEquipamento(new CaminhaoTanque(id, nome, custodiario, sc.nextDouble(), equipe));
                    }
                    case 3 -> {
                        acmeRescue.adicionarEquipamento(new Escavadeira(id, nome, custodiario, sc.next(), sc.nextDouble(), equipe));
                    }
                }
                sc.close();
                } catch(InputMismatchException e) {}
            } 
        } catch(Exception e) {}
        
    }
    
    private void readEquipe() {
        File arquivo = new File("ReadWrite/" + nomeArq + "-EQUIPES.csv");
        
        if (!arquivo.exists()) {
            jta.append("\nArquivo  " + nomeArq + "-EQUIPES.csv inexistsente");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();
            while((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha.trim()).useDelimiter("[;]");
                try {
                acmeRescue.adicionarEquipe(new Equipe(sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextDouble()));
                } catch(InputMismatchException e) {}
                sc.close();
            }
        } catch(Exception exception) {}
    }
    
}
