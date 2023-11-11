package Equipe.Equipamentos.Tipos;

import Equipe.Equipamentos.Equipamento;

public class Escavadeira extends Equipamento {

	private String combustivel;
	private double carga;

	public Escavadeira(int id, String nome, double custoDia, String combustivel, double carga) {
		super(id, nome, custoDia);
		this.combustivel = combustivel;
		this.carga = carga;
	}

	@Override
	public String getInfo() {return super.getId() + " E";}

	@Override
	public String getDescricao() {
		return "\n   Tipo: Escavadeira" +
				"\n   ID: " + super.getId() +
				"\n   Nome: " + super.getNome() +
				"\n   Custo Diario: " + super.getCustoDia() +
				"\n   Tipo de Combustivel" + combustivel +
				"\n   Carga: " + carga+ "\n";
	}
}
