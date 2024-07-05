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
    public boolean adicionarEquipe(Equipe equipe) {
        if(Objects.isNull(equipe) || 
        listaEquipe.stream().anyMatch(e -> equipe.getCodinome().equals(e.getCodinome()))) 
        {return false;}
        return listaEquipe.add(equipe);
    } 
    
    public Equipe pesquisarCodigoEquipe(String codigo) {
        if(codigo.isEmpty()) return null;
        for (Equipe equipe : listaEquipe) {
            if(codigo.equals(equipe.getCodinome())) return equipe;
        }
        return null;
    }

    //EVENTO-----------------------
    public boolean adicionarEvento(Evento evento) {
        if(Objects.isNull(evento) ||
        listaEvento.stream().anyMatch(e -> evento.getCodigo().equals(e.getCodigo()))) {return false;}
        return listaEvento.add(evento);
    }  

    //ATENDIMENTO---------------------   
    public boolean adicionarAtendimento(Atendimento atendimento) {
        if(atendimento == null || atendimento.getEvento() == null ||
        listaAtendimento.stream().anyMatch(at -> atendimento.getCodinome() == at.getCodinome())) return false;
        return listaAtendimento.add(atendimento);
    }

    public Atendimento pesquisarCodigoAtendimento(int codigo) {
        return listaAtendimento.stream().filter(at -> codigo == at.getCodinome()).findFirst().orElse(null);
    }

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
    
    public boolean adicionarEquipamento(Equipamento equipamento) {
        if(Objects.isNull(equipamento) || listaEquipamento.stream().anyMatch(e -> equipamento.getId() == e.getId())) return false;
        return listaEquipamento.add(equipamento);
    }
    
    public Equipamento pesquisarCodigoEquipamento(int codigo) {
        return listaEquipamento.stream().filter(e -> codigo == e.getId()).findFirst().orElse(null);
    }

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

    public String mostrarTodosEquipamentos() {
        return (listaEquipamento.isEmpty()) ? "Nenhum equipamento cadastrado\n" : "\n" + mostrarTodasEscavadeiras() + "\n" + mostrarTodosBarcos() + "\n" + mostrarTodosCaminhoes() + "\n";
    }
    
    public String mostrarTodasEscavadeiras() {
        String retorno = "Escavadeiras: \n";
        for (Equipamento e : listaEquipamento) {
            if (e instanceof Escavadeira eq) {
                retorno += eq.getDescricao() + "\n";
            }
        }
        return retorno = (retorno.equals("Escavadeiras: \n")) ? "Nenhuma escavadeira cadastrada\n" : retorno;
    }

    public String mostrarTodosCaminhoes() {
        String retorno = "Caminhoes: \n";
        for (Equipamento e : listaEquipamento) {
            if (e instanceof CaminhaoTanque c) {
                retorno += c.getDescricao() + "\n";
            }
        }
        return retorno = (retorno.equals("Caminhoes: \n")) ? "Nenhum caminhao adicionado\n" : retorno;
    }

    public String mostrarTodosBarcos() {
        String retorno = "Barcos: \n";
        for (Equipamento e : listaEquipamento) {
            if (e instanceof Barco b) {
                retorno += b.getDescricao() + "\n";
            }
        }
        return retorno = (retorno.equals("Barcos: \n")) ? "Nenhuma escavadeira adicionada\n" : retorno;
    }
    
    //ATENDIMENTOS INFO-----------------------
    
    public String getListaAtendimentos() {
        if (listaAtendimento.isEmpty()) {
            return "Lista vazia";
        }
        String ret = "";
        for (Atendimento at : listaAtendimento) {
            ret += "- " + at.getCodinome() + " " + at.getStatus().toUpperCase() + "\n";
        }
        return ret;
    }
        
    public String mostrarTodosAtendimentos() {
        String retorno = "Atendimentos: \n";
        for (Atendimento atendimento : listaAtendimento) {
            retorno += atendimento.getDescricao() + "\n\n";
        }
        return retorno = (retorno.equals("Atendimentos: \n")) ? "Nenhum atendimento cadastrado\n" : retorno;
    }
       
    //EVENTOS INFO -----------------------

    public Evento pesquisarCodigoEvento(String codigo) {
        for (Evento evento : listaEvento) {
            if (codigo.equals(evento.getCodigo())) {
                return evento;
            }
        }
        return null;
    }

    public String mostrarTodasSecas() {
        String retorno = "Secas: \n";
        for (Evento e : listaEvento) {
            if (e instanceof Seca s) {
                retorno += s.getDescricao() + "\n";
            }
        }
        return retorno = (retorno.equals("Secas: \n")) ? "Nenhuma seca cadastrada\n" : retorno;
    }

    public String mostrarTodosTerremotos() {
        String retorno = "Terremotos: \n";
        for (Evento e : listaEvento) {
            if (e instanceof Terremoto t) {
                retorno += t.getDescricao() + "\n";
            }
        }
        return retorno = (retorno.equals("Terremotos: \n")) ? "Nenhum terremoto cadastrado\n" : retorno;
    }

    public String mostrarTodosCiclones() {
        String retorno = "Ciclones: \n";
        for (Evento e : listaEvento) {
            if (e instanceof Ciclone c) {
                retorno += c.getDescricao() + "\n";
            }
        }
        return retorno = (retorno.equals("Ciclones: \n")) ? "Nenhum ciclone cadastrado\n" : retorno;
    }

    public String mostrarTodosEventos() {
        String retorno = "Eventos: \n";
        for (Evento e : listaEvento) {
            retorno += e.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Eventos: \n")) ? "Nenhum evento adicionado\n" : retorno;
    }
        
    //EQUIPES INFO-----------------------
    
    public String mostrarEquipesDisponiveis() {
        String retorno = "";
        for (Equipe equipe : listaEquipe) {
            retorno += "- " + equipe.getCodinome() + "\n";
        }
        return retorno;
    }
    
    public String mostrarTodasEquipes() {
        listaEquipe.sort((nome1, nome2) -> nome1.getCodinome().compareTo(nome2.getCodinome()));
        String lista = "Equipes: \n";
        for (Equipe e : listaEquipe) {
            lista += e.getDescricao();
        }
        return lista = (lista.equals("Equipes: \n")) ? "Nenhuma equipe cadastrada\n" : lista;
    }
    
    //GRAVACAO NORMAL-----------------------

    public String gravacaoNormalEquipe() {
        String retorno = "codinome;quantidade;latitude;longitude\n";
        for (Equipe e : listaEquipe) {
            retorno+=String.format("%s;%d;%f;%f%n", e.getCodinome(), e.getQuantidade(), e.getLatitude(), e.getLongitude());
        }
        return retorno;
    }
    
    public String gravacaoNormalEvento() {
        String retorno = "codigo;data;latitude;longitude;tipo;velocidade_magnitude_estiagem;precipitacao\n";
        for (Evento e : listaEvento) {
            if(e instanceof Ciclone c) {
                retorno += String.format("%s;%s;%f;%f;%d;%.1f;%.1f%n", c.getCodigo(), c.getData(), c.getLatitude(), c.getLongitude(), 1, 
                        c.getVelocidade(), c.getPrecipitacao());
            } else if(e instanceof Terremoto t) {
                retorno += String.format("%s;%s;%f;%f;%d;%.1f%n", t.getCodigo(), t.getData(), t.getLatitude(), t.getLongitude(), 2, t.getMagnitude());
            } else if(e instanceof Seca s) {
                retorno += String.format("%s;%s;%f;%f;%d;%d%n", s.getCodigo(), s.getData(), s.getLatitude(), s.getLongitude(), 3, s.getEstiagem());
            }
         }
        return retorno;
    }
    
    public String gravacaoNormalAtendimento() {
        String retorno = "cod;dataInicio;duracao;status;codigo_evento;codigo_equipe\n";
        for(Atendimento at : listaAtendimento) {
            retorno += (at.getEquipeAlocada() == null) ? String.format("%d;%s;%d;%s%n", at.getCodinome(), at.getData(), at.getDuracao(), at.getEvento().getCodigo()) 
            : 
            String.format("%d;%s;%d;%s;%s%n", at.getCodinome(), at.getData(), at.getDuracao(), at.getEvento().getCodigo(), at.getEquipeAlocada().getCodinome());
        }
        return retorno;
    }
    
    public String gravacaoNormalEquipamento() {
        String retorno = "identificador;nome;custodiario;codinome;tipo;capacidade_combustivel;carga\n";
        for (Equipamento T : listaEquipamento) {
            if(T instanceof Barco b) {
                retorno += String.format("%d;%s;%.2f;%s;%d;%d%n", b.getId(), b.getNome(), b.getCustoDia(), b.getEquipe().getCodinome(), 1, b.getCapacidade());
            } else if (T instanceof CaminhaoTanque c) {
                retorno += String.format("%d;%s;%.2f;%s;%d;%.1f%n", c.getId(), c.getNome(), c.getCustoDia(), c.getEquipe().getCodinome(), 2, c.getCapacidade());
            } else if (T instanceof Escavadeira e) {
                retorno += String.format("%d;%s;%.2f;%s;%d;%s;%.1f%n", e.getId(), e.getNome(), e.getCustoDia(), e.getEquipe().getCodinome(), 3, e.getCombustivel(), e.getCarga());
            }
        }
        return retorno;
    }
    
    //GRAVACAO JSON
    public List<Equipe> retornaListaEquipe() { return listaEquipe.stream().collect(Collectors.toList());}
    public List<Atendimento> retornaListaAtendimento() {return listaAtendimento.stream().collect(Collectors.toList());}
    public List<Equipamento> retornaListaEquipamento() {return listaEquipamento.stream().collect(Collectors.toList());}
    public List<Evento> retornaListaEvento() {return listaEvento.stream().collect(Collectors.toList());}
    
}
