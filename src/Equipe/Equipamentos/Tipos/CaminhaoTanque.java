package Equipe.Equipamentos.Tipos;

import Equipe.Equipamentos.Equipamento;

public class CaminhaoTanque extends Equipamento {

	private double capacidade;

	public CaminhaoTanque(int id, String nome, double custoDia, double capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
	}

	@Override
	public String getInfo() {return super.getId() + " C";}

	@Override
	public String getDescricao() {
		return "\n   Tipo: Caminhao Tanque" +
				"\n   ID: " + super.getId() +
				"\n   Nome: " + super.getNome() +
				"\n   Custo Diario: " + super.getCustoDia() +
				"\n   Capacidade: " + capacidade+ "\n";
	}
}
