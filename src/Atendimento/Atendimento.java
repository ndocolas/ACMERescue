package Atendimento;

import Equipe.Equipe;
import Eventos.Evento;

public class Atendimento {

	private int cod;
	private String dataInicio;
	private int duracao;
    private String status;

	private Evento evento;
	private Equipe equipeAlocada;
	
	public Atendimento(int codigo, String dataInicio, int duracao, Evento evento) {
		cod = codigo;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.evento = evento;
		equipeAlocada = null;
        status = "PEENDENTE";
	}
	
	public int getCodinome() {return cod;}
	public String getData() {return dataInicio;}
	public Evento getEvento() {return evento;}
	public String getEquipeDescricao() {return (equipeAlocada.equals(null)) ? "Nenhuma equipe alocada":equipeAlocada.getDescricao();}
    public String getDescricao() {
        return "Codigo: " + cod +
                "\nData: " + dataInicio +
                "\nDuracao: " + duracao + " dias" +
                "\nStatus: " + status +
				"\nEvento: " + evento.getDescricao();
    }
}
