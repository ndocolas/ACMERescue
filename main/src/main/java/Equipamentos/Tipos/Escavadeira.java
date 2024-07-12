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
		return String.format("Tipo: Escavadeira  ID: %d    Nome: %s    Custo Diario: %.2f    Tipo de Combustivel: %s    Carga: %.2f    Equipe: %s",
				super.getId(), super.getNome(), super.getCustoDia(), combustivel.toUpperCase(), carga, super.getEquipe().getCodinome());
	}
}
