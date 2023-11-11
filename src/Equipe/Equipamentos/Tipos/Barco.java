package Equipe.Equipamentos.Tipos;

import Equipe.Equipamentos.Equipamento;

public class Barco extends Equipamento {

	private int capacidade;

	public Barco(int id, String nome, double custoDia, int capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
	}

	@Override
	public String getInfo() {return super.getId() + " B";}

	@Override
	public String getDescricao() {
		return "\n   Tipo: Barco" +
				"\n   ID: " + super.getId() +
				"\n   Nome: " + super.getNome() +
				"\n   Custo Diario: " + super.getCustoDia() +
				"\n   Capacidade: " + capacidade + "\n";
	}
}
