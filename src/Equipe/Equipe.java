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
    public int getquantidade() {return quantidade;}
    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    public boolean getIsAlocada() {return isAlocada;}
    public void setIsAlocada() {isAlocada = true;}

    public String getDescricao() {
        return (listaEquipamentos.isEmpty()) ? 
        "\nCodinome: " + codinome
        + "\nQuantidade: " + quantidade
        + "\nLatitude: " + latitude
        + "\nLongitude: " + longitude  + "\n"
        : 
        "\nCodinome: " + codinome
        + "\nQuantidade: " + quantidade
        + "\nLatitude: " + latitude
        + "\nLongitude: " + longitude
        + "\nEquipamento: \n" + equipamentosEquipeToString() + "\n";
    }

    public double calculaDistancia(double lat, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat - latitude);
        double lonDistance = Math.toRadians(lon2 - longitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(lat)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }

    public boolean adicionarEquipamento(Equipamento equipamento) {
        if(equipamento.getIsAdded()) return false;
        for (Equipamento e : listaEquipamentos) {
            if(equipamento.getId() == e.getId()) return false;
        }
        equipamento.setIsAdded();
        return listaEquipamentos.add(equipamento);
    }
    
    public String equipamentosEquipeToString() {
        listaEquipamentos.sort(Comparator.comparingInt(e -> e.getId()));
        String fim = "";
        for (Equipamento equipamento : listaEquipamentos) {
            fim += equipamento.getDescricao();
        }
        return fim;
    }
}
