
import Atendimento.Atendimento;
import Equipe.Equipe;
import Equipe.Equipamentos.Equipamento;
import Equipe.Equipamentos.Tipos.Barco;
import Equipe.Equipamentos.Tipos.CaminhaoTanque;
import Equipe.Equipamentos.Tipos.Escavadeira;
import Eventos.Evento;
import Eventos.Tipos.Ciclone;
import Eventos.Tipos.Seca;
import Eventos.Tipos.Terremoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ACMERescue {
    
    private ArrayList<Equipe> listaEquipe;
    private ArrayList<Evento> listaEvento;
    private ArrayList<Equipamento> listaEquipamento;
    private List<Atendimento> listaAtendimento;
    
    public ACMERescue() {
       listaEquipe = new ArrayList<>();
       listaEvento = new ArrayList<>();
       listaEquipamento = new ArrayList<>();
       listaAtendimento = Collections.synchronizedList(new LinkedList<>());
    }
    
    //GERAL
    public String mostrarRelatorio() {
        return (listaEquipamento.isEmpty() && listaEquipe.isEmpty() && 
        listaAtendimento.isEmpty() && listaEvento.isEmpty()) ? 
        "Nenhum dado cadastrado." : mostrarTodasEquipes() +
                                    mostrarTodosEquipamentos() +
                                    mostrarTodosEventos() +
                                    mostrarTodosAtendimentos();


    }

    //EQUIPE-----------------------
    public boolean adicionarEquipe(Equipe equipe) {
        if (equipe == null)return false;
        for (Equipe var : listaEquipe) {
            if (equipe.getCodinome().equals(var.getCodinome())) return false;
        }
        return listaEquipe.add(equipe);
    } 

    public String mostrarTodasEquipes() {
        listaEquipe.sort((nome1, nome2) -> nome1.getCodinome().compareTo(nome2.getCodinome()));
        String lista = "Equipes: \n";
        for (Equipe e : listaEquipe) { lista += e.getDescricao();}
        return lista = (lista.equals("Equipes: \n")) ? "Nenhuma equipe cadastrada" : lista;
    }
    
    public Equipe pesquisarCodigoEquipe(String codigo) {
        if(codigo.isEmpty()) return null;
        for (Equipe equipe : listaEquipe) {
            if(codigo.equals(equipe.getCodinome())) return equipe;
        }
        return null;
    }

    //EVENTO------------------------
    public boolean adicionarEvento(Evento evento) {
        if(evento==null) return false;
        for(Evento e : listaEvento) {
            if(evento.getCodigo().equals(e.getCodigo())) return false;
        }
        return listaEvento.add(evento);
    }  
    
    public Evento pesquisarCodigoEvento(String codigo) {
        for (Evento evento : listaEvento) {
            if(codigo.equals(evento.getCodigo())) return evento;
        }
        return null;
    }
    
    public String mostrarTodasSecas() {
        String retorno = "Secas: \n";
        for(Evento e : listaEvento) {
            if(e instanceof Seca s) retorno += s.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Secas: \n")) ? "\nNenhuma seca cadastrada" : retorno;
    }
    
    public String mostrarTodosTerremotos() {
        String retorno = "Terremotos: \n";
        for(Evento e:listaEvento) {
            if(e instanceof Terremoto t) retorno += t.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Terremotos: \n")) ? "\nNenhum terremoto cadastrado" : retorno;
    }
    
    public String mostrarTodosCiclones() {
        String retorno = "Ciclones: \n";
        for(Evento e : listaEvento) {
            if(e instanceof Ciclone c) retorno += c.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Ciclones: \n")) ? "\nNenhum ciclone cadastrado" : retorno;
    }
    
    public String mostrarTodosEventos() {
        String retorno = "Eventos: \n";
        for(Evento e: listaEvento) {
            retorno += e.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Eventos: \n")) ? "Nenhum evento adicionado" : retorno;
    }

    //ATENDIMENTO--------------------
    public boolean adicionarAtendimento(Atendimento atendimento) {
        if(atendimento == null || atendimento.getEvento() == null) return false;
        for (Atendimento att : listaAtendimento) {
            if(atendimento.getCodinome() == att.getCodinome() ||
            atendimento.getEvento().equals(att.getEvento())) return false;
        }
        return listaAtendimento.add(atendimento);
    }
    
    public String mostrarTodosAtendimentos() {
        String retorno = "Atendimentos: \n";
        for (Atendimento atendimento : listaAtendimento) {
            retorno += atendimento.getDescricao() + "\n\n";
        }
        return retorno = (retorno.equals("Atendimentos: \n")) ? "Nenhum atendimento cadastrado" : retorno;
    }

    public Atendimento pesquisarCodigoAtendimento(int codigo) {
        for (Atendimento atendimento : listaAtendimento) {
            if(codigo == atendimento.getCodinome()) return atendimento;
        }
        return null;
    }

    public void alocacaoAutomatica() {
        List<Equipe> listaEquipesDisponiveis =
         listaEquipe.stream()
        .filter(e -> e.getIsAlocada()==false).collect(Collectors.toList());
        for (Atendimento atendimento : listaAtendimento) {
            
        }
    }

    //EQUIPAMENTOS----------------------
    
    public boolean adicionarEquipamento(Equipamento equipamento) {
        if(equipamento == null) return false;
        for (Equipamento e : listaEquipamento) {
            if(equipamento.getId() == e.getId()) return false;
        }
        return listaEquipamento.add(equipamento);
    }
    
    public Equipamento pesquisarCodigoEquipamento(int codigo) {
        for (Equipamento equipamento : listaEquipamento) {
            if(codigo==equipamento.getId()) return equipamento;
        }          
        return null;
    }

    public String mostrarTodasEscavadeiras() {
        String retorno = "Escavadeiras: \n";
        for(Equipamento e : listaEquipamento) {
            if(e instanceof Escavadeira eq) retorno += eq.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Escavadeiras: \n")) ? "Nenhuma escavadeira cadastrada" : retorno;
    }
    
    public String mostrarTodosCaminhoes() {
        String retorno = "Caminhoes: \n";
        for (Equipamento e : listaEquipamento) {
            if (e instanceof CaminhaoTanque c) retorno += c.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Caminhoes: \n")) ? "Nenhum caminhao adicionado" : retorno;
        }
     
    public String mostrarTodosBarcos() {
        String retorno = "Barcos: \n";
        for (Equipamento e : listaEquipamento) {
            if (e instanceof Barco b) retorno += b.getDescricao() + "\n";
        }
        return retorno = (retorno.equals("Barcos: \n")) ? "Nenhuma escavadeira adicionada" : retorno;
    }

    public String mostrarTodosEquipamentos() {
        return (listaEquipamento.isEmpty()) ? "Nenhum equipamento cadastrado" : mostrarTodasEscavadeiras() + "\n" + mostrarTodosBarcos() + "\n" + mostrarTodosCaminhoes();
    }
}
