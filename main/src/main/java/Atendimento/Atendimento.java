package Atendimento;

import Equipe.Equipe;
import Eventos.Evento;

public class Atendimento {

    private int codigo;
    private String dataInicio;
    private int duracao;
    private String status;

    private Evento evento;
    private Equipe equipeAlocada;

    public Atendimento(int codigo, String dataInicio, int duracao, Evento evento, Equipe equipe) {
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.duracao = duracao;
        this.evento = evento;
        equipeAlocada = equipe;
        status = "EXECUTANDO";
    }

    public Atendimento(int codigo, String dataInicio, int duracao, Evento evento) {
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.duracao = duracao;
        this.evento = evento;
        status = "PENDENTE";
        equipeAlocada = null;
    }

    private void desalocarEquipe(String status) {
         if (equipeAlocada != null) {
            equipeAlocada.setIsAlocada(false);
            equipeAlocada = null;
            this.status = status;
        }
    }


    public void alterarStatus(String status) {
        switch (status.toUpperCase()) {
            case "PENDENTE": desalocarEquipe(status);
            case "FINALIZADO": desalocarEquipe(status);
            case "CANCELADO": desalocarEquipe(status);
            default: return;
        }
    }

    public boolean setEquipe(Equipe e) {
        if (equipeAlocada == null) {
            equipeAlocada = e;
            status = "EXECUTANDO";
            return true;
        }
        return false;
    }

    public Equipe getEquipeAlocada() {return equipeAlocada;}    
    public int getCodinome() {return codigo;}   
    public String getData() {return dataInicio;}    
    public int getDuracao() {return duracao;}   
    public Evento getEvento() {return evento;}
    public String getStatus() {return status;}

    public String getEquipeDescricao() {
        return (equipeAlocada == null) ? "Nenhuma equipe alocada\n" :  equipeAlocada.getDescricao();
    }

    public double calculaPrecoAtendimento() {
        return equipeAlocada.calculaPrecoTotal(duracao, evento.getLatitude(), evento.getLongitude());
    }

    public String getDescricao() {
        return (equipeAlocada == null) ? 
        String.format("Codigo: %d%nData: %s%nDuracao: %d dias%nStatus: %s%nEvento: %s%nCusto Total: Atendimento sem equipe", codigo, dataInicio, duracao, status, evento.getDescricao())
        :  
        String.format("Codigo: %d%nData: %s%nDuracao: %d dias%nStatus: %s%nEvento: %s%nCusto Total: %.2f%nEquipe: %s%n", codigo, dataInicio, duracao, status, evento.getDescricao(), calculaPrecoAtendimento(), equipeAlocada.getDescricao());
    }
}