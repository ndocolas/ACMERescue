package Equipamentos.Tipos;

import Equipamentos.Equipamento;
import Equipe.Equipe;

public class Escavadeira extends Equipamento {

	private String combustivel;
	private double carga;

	public Escavadeira(int id, String nome, double custoDia, String combustivel, double carga, Equipe equipe) {
        super(id, nome, custoDia, equipe);
		this.combustivel = combustivel;
		this.carga = carga;
	}

	@Override
	public String getInfo() {return super.getId() + " E";}
    public String getCombustivel() {return combustivel;}
    public double getCarga() {return carga;}   

	@Override
	public String getDescricao() {
		return "\n   Tipo: Escavadeira" +
				"\n   ID: " + super.getId() +
				"\n   Nome: " + super.getNome() +
				"\n   Custo Diario: " + super.getCustoDia() +
				"\n   Tipo de Combustivel: " + combustivel.toUpperCase() +
				"\n   Carga: " + carga +
                                "\n   Equipe: " + super.getEquipe().getCodinome() + "\n";
	}
}
