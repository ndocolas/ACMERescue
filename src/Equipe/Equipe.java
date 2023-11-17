package Equipe;

import java.util.ArrayList;
import java.util.Comparator;

import Equipe.Equipamentos.Equipamento;

public class Equipe {

	private String codinome;
	private int quantidade;
        private double latitude;
        private double longitude;
        private boolean isAlocada;
        private ArrayList<Equipamento> listaEquipamentos;

	public Equipe(String codinome, int quantidade, double latitude, double longitude) {
        this.codinome = codinome;
        this.quantidade = quantidade;
        this.latitude = latitude;
        this.longitude = longitude;
        listaEquipamentos = new ArrayList<>();
        isAlocada = false;
    }

    public String getCodinome() {return codinome;}
    public int getQuantidade() {return quantidade;}
    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    public boolean getIsAlocada() {return isAlocada;}
    public void setIsAlocada(boolean tipo) {isAlocada = tipo;}

    public boolean adicionarEquipamento(Equipamento equipamento) {
        if(!equipamento.getEquipe().equals(this)) return false;
        for (Equipamento e : listaEquipamentos) {
            if(equipamento.getId() == e.getId()) return false;
        }
        return listaEquipamentos.add(equipamento);
    }
    
    public double calculaDistancia(double lat, double lon) {
        final int R = 6371;
        double latDistance = Math.toRadians(latitude- lat);
        double lonDistance = Math.toRadians(longitude - lon);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(lat))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }
    
    public double calcularPrecoEquipe(int duracao) {
        return 250*duracao*quantidade;
    }
    
    public double calculaPrecoEquipamento(int duracao) {
        return listaEquipamentos.stream().
                mapToDouble(e->e.getCustoDia()).sum() * duracao;
    }
    
    public double calculaPrecoDeslocamento(double lat, double lon) {
        return calculaDistancia(lat, lon) * (100 * quantidade * (0.1 * listaEquipamentos.stream().mapToDouble(e -> e.getCustoDia()).sum()));
    }
    
    public String getDescricao() {
        return "\n   Codinome: " + codinome
                + "\n   Quantidade: " + quantidade
                + "\n   Latitude: " + latitude
                + "\n   Longitude: " + longitude + "\n";
    }
    
    public String equipamentosEquipeToString() {
        listaEquipamentos.sort(Comparator.comparingInt(e -> e.getId()));
        String fim = "";
        for (Equipamento equipamento : listaEquipamentos) {
            fim += equipamento.getDescricao();
        }
        return fim = (listaEquipamentos.isEmpty()) ? " Lista vazia" : fim;
    }
}
