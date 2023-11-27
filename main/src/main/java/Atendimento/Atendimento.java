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

    public Atendimento(int codigo, String dataInicio, int duracao, String status, Evento evento) {
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.duracao = duracao;
        this.evento = evento;
        this.status = status;
        equipeAlocada = null;
    }

    public Atendimento(int codigo, String dataInicio, int duracao, Evento evento) {
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.duracao = duracao;
        this.evento = evento;
        status = "PENDENTE";
        equipeAlocada = null;
    }

    public String getStatus() {
        return status;
    }

    public void alterarStatus(String status) {
        switch (status.toUpperCase()) {
            case "PENDENTE" -> {
                this.status = status;
                break;
            }
            case "EXECUTANDO" -> {
                this.status = status;
                break;
            }
            case "FINALIZADO" -> {
                if (equipeAlocada != null) {
                    equipeAlocada.setIsAlocada(false);
                    equipeAlocada = null;
                }
                this.status = status;
                break;
            }
            case "CANCELADO" -> {
                if (equipeAlocada != null) {
                    equipeAlocada.setIsAlocada(false);
                    equipeAlocada = null;
                }
                this.status = status;
                break;
            }
            default -> {
                return;
            }
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

    public Equipe getEquipeAlocada() {
        return equipeAlocada;
    }

    public int getCodinome() {
        return codigo;
    }

    public String getData() {
    return dataInicio;
    }   

    public int getDuracao() {
    return duracao;
    }

    public Evento getEvento() {
    return evento;
    }

    public String getEquipeDescricao() {
        return (equipeAlocada == null) ? "Nenhuma equipe alocada\n" : equipeAlocada.getDescricao();
    }

    public double calculaPrecoAtendimento() {
        return equipeAlocada.calculaPrecoTotal(duracao, evento.getLatitude(), evento.getLongitude());
    }

    public String getDescricao() {
        return (equipeAlocada == null) ? "Codigo: " + codigo
                + "\nData: " + dataInicio
                + "\nDuracao: " + duracao + " dias"
                + "\nStatus: " + status
                + "\nEvento: " + evento.getDescricao()
                + "\nCusto Total: Atendimento sem equipe"
                : "Codigo: " + codigo
                        + "\nData: " + dataInicio
                        + "\nDuracao: " + duracao + " dias"
                        + "\nStatus: " + status
                        + "\nEvento: " + evento.getDescricao()
                        + "\nCusto Total: " + calculaPrecoAtendimento()
                        + "\nEquipe: " + equipeAlocada.getDescricao();

    }
}