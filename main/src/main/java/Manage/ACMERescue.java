package Manage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

import Atendimento.Atendimento;
import Equipamentos.Equipamento;
import Equipamentos.Tipos.Barco;
import Equipamentos.Tipos.CaminhaoTanque;
import Equipamentos.Tipos.Escavadeira;
import Equipe.Equipe;
import Eventos.Evento;
import Eventos.Tipos.Ciclone;
import Eventos.Tipos.Seca;
import Eventos.Tipos.Terremoto;

public class ACMERescue {
    
    private ArrayList<Equipe> listaEquipe;
    private ArrayList<Evento> listaEvento;
    private ArrayList<Equipamento> listaEquipamento;
    private Queue<Atendimento> listaAtendimento;
    
    public ACMERescue() {
       listaEquipe = new ArrayList<>();
       listaEvento = new ArrayList<>();
       listaEquipamento = new ArrayList<>();
       listaAtendimento = new LinkedList<>();
    }

    //EQUIPE-----------------------
    public boolean adicionarEquipe(Equipe equipe) {return listaEquipe.stream().anyMatch(e -> equipe.getCodinome().equals(e.getCodinome())) ? false : listaEquipe.add(equipe);}
 
    
    public Equipe pesquisarCodigoEquipe(String codigo) {return listaEquipe.stream().filter(e -> codigo.equals(e.getCodinome())).findFirst().orElse(null);}

    //EVENTO-----------------------
    public boolean adicionarEvento(Evento evento) {return Objects.isNull(evento) || listaEvento.stream().anyMatch(e -> evento.getCodigo().equals(e.getCodigo())) ? false : listaEvento.add(evento);}
 

    //ATENDIMENTO---------------------   
    public boolean adicionarAtendimento(Atendimento atendimento) {
        return atendimento == null || atendimento.getEvento() == null ||
        listaAtendimento.stream().anyMatch(at -> atendimento.getCodinome() == at.getCodinome()) ? false : listaAtendimento.add(atendimento);
    }

    public Atendimento pesquisarCodigoAtendimento(int codigo) {return listaAtendimento.stream().filter(at -> codigo == at.getCodinome()).findFirst().orElse(null);}

    public void alocacaoAutomatica() {
        if (listaAtendimento.isEmpty() || listaEquipe.isEmpty()) return;
        for (Atendimento at : listaAtendimento) {
            if(at.getStatus().equals("CANCELADO") || at.getStatus().equals("FINALIZADO") || at.getEquipeAlocada() != null) continue;
            boolean cancelar = true;
            for (Equipe e : listaEquipe) {
                if(e.getIsAlocada()) continue;
                if(e.calculaDistancia(at.getEvento().getLatitude(), at.getEvento().getLongitude()) <= 5000) {
                    at.setEquipe(e);
                    e.setIsAlocada(true);
                    cancelar = false;
                    break;
                } else {
                    continue;
                }
            }
            if(cancelar) {
                at.alterarStatus("CANCELADO");
            }
        }
    }
    
    //EQUIPAMENTOS----------------------
    
    public boolean adicionarEquipamento(Equipamento equipamento) {return Objects.isNull(equipamento) || listaEquipamento.stream().anyMatch(e -> equipamento.getId() == e.getId()) ? false : listaEquipamento.add(equipamento);}
    
    public Equipamento pesquisarCodigoEquipamento(int codigo) {return listaEquipamento.stream().filter(e -> codigo == e.getId()).findFirst().orElse(null);}

    //GERAL-----------------------

    public String mostrarRelatorio() {
        return (listaEquipamento.isEmpty() && listaEquipe.isEmpty()
                && listaAtendimento.isEmpty() && listaEvento.isEmpty())
                ? "Nenhum dado cadastrado." : 
                mostrarTodasEquipes()
                + mostrarTodosEquipamentos()
                + mostrarTodosEventos()
                + mostrarTodosAtendimentos();

    }

    //EQUIPAMENTOS INFO-----------------------

    public String mostrarTodosEquipamentos() {return (listaEquipamento.isEmpty()) ? "Nenhum equipamento cadastrado\n" : "\n" + mostrarTodasEscavadeiras() + "\n" + mostrarTodosBarcos() + "\n" + mostrarTodosCaminhoes() + "\n";}
    
    public String mostrarTodasEscavadeiras() {return "Escavadeiras: \n" + listaEquipamento.stream().filter(e -> e instanceof Escavadeira).map(Equipamento::getDescricao).collect(Collectors.joining("\n"));}

    public String mostrarTodosCaminhoes() {return "Caminhoes: \n" + listaEquipamento.stream().filter(e -> e instanceof CaminhaoTanque).map(Equipamento::getDescricao).collect(Collectors.joining("\n"));}

    public String mostrarTodosBarcos() {return "Barcos: \n" + listaEquipamento.stream().filter(e -> e instanceof Barco).map(Equipamento::getDescricao).collect(Collectors.joining("\n"));}
    
    //ATENDIMENTOS INFO-----------------------
    
    public String getListaAtendimentos() {return (listaAtendimento.isEmpty()) ? "Lista vazia": listaAtendimento.stream().map(Atendimento::getDescricao).collect(Collectors.joining("\n"));}
        
    public String mostrarTodosAtendimentos() {return "Atendimentos: \n" + listaAtendimento.stream().map(Atendimento::getDescricao).collect(Collectors.joining("\n"));}
       
    //EVENTOS INFO -----------------------

    public Evento pesquisarCodigoEvento(String codigo) {return listaEvento.stream().filter(e -> codigo.equals(e.getCodigo())).findFirst().orElse(null);}

    public String mostrarTodasSecas() {return "Secas: \n" + listaEvento.stream().filter(e -> e instanceof Seca).map(Evento::getDescricao).collect(Collectors.joining("\n"));}

    public String mostrarTodosTerremotos() {return "Terremotos: \n" + listaEvento.stream().filter(e -> e instanceof Terremoto).map(Evento::getDescricao).collect(Collectors.joining("\n"));}

    public String mostrarTodosCiclones() {return "Ciclones: \n" + listaEvento.stream().filter(e -> e instanceof Ciclone).map(Evento::getDescricao).collect(Collectors.joining("\n"));}

    public String mostrarTodosEventos() {return "Eventos: \n" + listaEvento.stream().map(Evento::getDescricao).collect(Collectors.joining("\n"));}
        
    //EQUIPES INFO-----------------------
    
    public String mostrarEquipesDisponiveis() {return listaEquipe.stream().map(equipe -> "- " + equipe.getCodinome() + "\n").collect(Collectors.joining("\n"));}
    
    public String mostrarTodasEquipes() {
        listaEquipe.sort((nome1, nome2) -> nome1.getCodinome().compareTo(nome2.getCodinome()));return (listaEquipe.isEmpty()) ? "Nenhuma equipe cadastrada\n" : "Equipes: \n" + listaEquipe.stream().map(Equipe::getDescricao).collect(Collectors.joining("\n"));}
    
    //GRAVACAO NORMAL-----------------------

    public String gravacaoNormalEquipe() {return "codinome;quantidade;latitude;longitude\n" + listaEquipe.stream().map(e -> String.format("%s;%d;%.2f;%.2f", e.getCodinome(), e.getQuantidade(), e.getLatitude(), e.getLongitude())).collect(Collectors.joining("\n"));}
    
    public String gravacaoNormalEvento() {
        String retorno = "codigo;data;latitude;longitude;tipo;velocidade_magnitude_estiagem;precipitacao\n";
        for (Evento e : listaEvento) {
            if(e instanceof Ciclone c)  retorno += String.format("%s;%s;%f;%f;%d;%.1f;%.1f%n", c.getCodigo(), c.getData(), c.getLatitude(), c.getLongitude(), 1, c.getVelocidade(), c.getPrecipitacao());
            else if(e instanceof Terremoto t) retorno += String.format("%s;%s;%f;%f;%d;%.1f%n", t.getCodigo(), t.getData(), t.getLatitude(), t.getLongitude(), 2, t.getMagnitude());
            else if(e instanceof Seca s) retorno += String.format("%s;%s;%f;%f;%d;%d%n", s.getCodigo(), s.getData(), s.getLatitude(), s.getLongitude(), 3, s.getEstiagem());
            
         }
        return retorno;
    }
    
    public String gravacaoNormalAtendimento() {return "cod;dataInicio;duracao;status;codigo_evento;codigo_equipe\n" + listaAtendimento.stream().map(at -> (at.getEquipeAlocada() == null) ? String.format("%d;%s;%d;%s;%s%n", at.getCodinome(), at.getData(), at.getDuracao(), at.getStatus(), at.getEvento().getCodigo()) : String.format("%d;%s;%d;%s;%s;%s%n", at.getCodinome(), at.getData(), at.getDuracao(), at.getStatus(), at.getEvento().getCodigo(), at.getEquipeAlocada().getCodinome())).collect(Collectors.joining("\n"));}
    
    public String gravacaoNormalEquipamento() {
        String retorno = "identificador;nome;custodiario;codinome;tipo;capacidade_combustivel;carga\n";
        for (Equipamento T : listaEquipamento) {
            if(T instanceof Barco b) retorno += String.format("%d;%s;%.2f;%s;%d;%d%n", b.getId(), b.getNome(), b.getCustoDia(), b.getEquipe().getCodinome(), 1, b.getCapacidade());
            else if (T instanceof CaminhaoTanque c) retorno += String.format("%d;%s;%.2f;%s;%d;%.1f%n", c.getId(), c.getNome(), c.getCustoDia(), c.getEquipe().getCodinome(), 2, c.getCapacidade());
            else if (T instanceof Escavadeira e) retorno += String.format("%d;%s;%.2f;%s;%d;%s;%.1f%n", e.getId(), e.getNome(), e.getCustoDia(), e.getEquipe().getCodinome(), 3, e.getCombustivel(), e.getCarga());
        }
        return retorno;
    }
    
    //GRAVACAO JSON
    public List<Equipe> retornaListaEquipe() {return listaEquipe.stream().collect(Collectors.toList());}
    public List<Atendimento> retornaListaAtendimento() {return listaAtendimento.stream().collect(Collectors.toList());}
    public List<Equipamento> retornaListaEquipamento() {return listaEquipamento.stream().collect(Collectors.toList());}
    public List<Evento> retornaListaEvento() {return listaEvento.stream().collect(Collectors.toList());}
    
}
