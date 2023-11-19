package Equipe.Equipamentos.Tipos;

import Equipe.Equipamentos.Equipamento;
import Equipe.Equipe;

public class CaminhaoTanque extends Equipamento {

	private double capacidade;

	public CaminhaoTanque(int id, String nome, double custoDia, double capacidade, Equipe equipe) {
        super(id, nome, custoDia, equipe);
		this.capacidade = capacidade;
	}
        
    public double getCapacidade() {return capacidade;}

	@Override
	public String getInfo() {return super.getId() + " C";}

	@Override
	public String getDescricao() {
		return "\n   Tipo: Caminhao Tanque" +
				"\n   ID: " + super.getId() +
				"\n   Nome: " + super.getNome() +
				"\n   Custo Diario: " + super.getCustoDia() +
				"\n   Capacidade: " + capacidade+
                                "\n   Equipe: " + super.getEquipe().getCodinome() + "\n";
	}
}
