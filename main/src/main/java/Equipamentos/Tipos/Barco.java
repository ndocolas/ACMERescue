package Equipamentos.Tipos;

import Equipamentos.Equipamento;
import Equipe.Equipe;

public class Barco extends Equipamento {

    private int capacidade;
    
    public Barco(int id, String nome, double custoDia, int capacidade, Equipe equipe) {
        super(id, nome, custoDia, equipe);
        this.capacidade = capacidade;
    }

    @Override
    public String getInfo() { return super.getId() + " B";}
    public int getCapacidade() {return capacidade;}

    @Override
    public String getDescricao() {
        return "\n   Tipo: Barco"
                + "\n   ID: " + super.getId()
                + "\n   Nome: " + super.getNome()
                + "\n   Custo Diario: " + super.getCustoDia()
                + "\n   Capacidade: " + capacidade
                + "\n   Equipe: " + super.getEquipe().getCodinome() + "\n";
    }
}
