/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReadWrite;

import Manage.ACMERescue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author nico
 */
public class GravacaoDeArquivos {
    
    private String arquivo;
    private ACMERescue acme;
    
    public GravacaoDeArquivos(String arquivo, ACMERescue acme) {
        this.acme = acme;
        this.arquivo = arquivo;
        gravarTudo();
    }
    
    public void gravarTudo() {
        gravarEquipe();
        gravarAtendimento();
        gravarEquipamento();
        gravarEvento();
    }
    
    private void gravarEquipe() {
        File file = new File("ReadWrite/ESCRITA/NORMAL/" + arquivo + "-EQUIPES.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String data = acme.gravacaoNormalEquipe();
                    bw.write(data);
            }
        } catch (IOException e) {}
    }
    
    private void gravarAtendimento() {
        File file = new File("ReadWrite/ESCRITA/NORMAL/" + arquivo + "-ATENDIMENTOS.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String data = acme.gravacaoNormalAtendimento();
                bw.write(data);
            }
        } catch (IOException e) {
        }
    }
    
    private void gravarEquipamento() {
        File file = new File("ReadWrite/ESCRITA/NORMAL/" + arquivo + "-EQUIPAMENTOS.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String data = acme.gravacaoNormalEquipamento();
                bw.write(data);
            }
        } catch (IOException e) {
        }
    }
    
    private void gravarEvento() {
        File file = new File("ReadWrite/ESCRITA/NORMAL/" + arquivo + "-EVENTOS.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String data = acme.gravacaoNormalEvento();
                bw.write(data);
            }
        } catch (IOException e) {
        }
    }
    
    
    
}
