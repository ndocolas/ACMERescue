package Equipe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import Equipamentos.Equipamento;

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
        isAlocada = false;
        listaEquipamentos = new ArrayList<>();
    }
    
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
    
    public double calculaPrecoTotal(int duracao, double lat, double lon) {
        double precoEquipamentos = (listaEquipamentos != null) ? somatorioListaEquipamentos() : 0;

        return (250 * duracao * quantidade) + (precoEquipamentos + (calculaDistancia(lat, lon) +
                 (100 * quantidade * (0.1 * precoEquipamentos))));
    }

    public double somatorioListaEquipamentos() {
        return listaEquipamentos.stream().mapToDouble(Equipamento::getCustoDia).sum();
    }

    public String getCodinome() {return codinome;}
    public int getQuantidade() {return quantidade;}
    public double getLatitude() {return latitude;}
    public double getLongitude() {return longitude;}
    
    public String getDescricao(){return String.format("%nCodinome: %s %nQuantidade: %d    %nLatitude: %.2f    %nLongitude: %.2%n", codinome, quantidade, latitude, longitude);}

    public String equipamentosEquipeToString() {
        listaEquipamentos.sort(Comparator.comparingInt(e -> e.getId()));
        return (listaEquipamentos.isEmpty()) ? 
        "Lista vazia" 
        : 
        listaEquipamentos.stream().map(e -> e.getDescricao()).collect(Collectors.toList()).toString();
    }
}
