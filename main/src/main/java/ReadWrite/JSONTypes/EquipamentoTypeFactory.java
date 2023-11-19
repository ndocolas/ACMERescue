package ReadWrite.JSONTypes;

import Equipe.Equipamentos.Equipamento;
import Equipe.Equipamentos.Tipos.Barco;
import Equipe.Equipamentos.Tipos.CaminhaoTanque;
import Equipe.Equipamentos.Tipos.Escavadeira;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class EquipamentoTypeFactory implements TypeAdapterFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!Equipamento.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        if (Barco.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new BarcoType();
        } else if (CaminhaoTanque.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new CaminhaoTanqueType();
        } else if (Escavadeira.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new EscavadeiraType();
        }

        throw new IllegalArgumentException("Unrecognized type: " + type.getRawType().getName());
    }
}

class BarcoType extends TypeAdapter<Barco> {

    @Override
    public void write(JsonWriter out, Barco b) throws IOException {
        out.beginObject();
        out.name("identificador").value(b.getId());
        out.name("nome").value(b.getNome());
        out.name("custoDiario").value(b.getCustoDia());
        out.name("capacidade").value(b.getCapacidade());
        out.name("equipe").value(b.getEquipe().getCodinome());
        out.name("tipo").value(1);
        out.endObject();
    }

    @Override
    public Barco read(JsonReader in) throws IOException {
        return null;
    }

}

class CaminhaoTanqueType extends TypeAdapter<CaminhaoTanque> {

    @Override
    public void write(JsonWriter out, CaminhaoTanque c) throws IOException {
        out.beginObject();
        out.name("identificador").value(c.getId());
        out.name("nome").value(c.getNome());
        out.name("custoDiario").value(c.getCustoDia());
        out.name("capacidade").value(c.getCapacidade());
        out.name("equipe").value(c.getEquipe().getCodinome());
        out.name("tipo").value(2);
        out.endObject();
    }

    @Override
    public CaminhaoTanque read(JsonReader in) throws IOException {
        return null;
    }

}

class EscavadeiraType extends TypeAdapter<Escavadeira> {

    @Override
    public void write(JsonWriter out, Escavadeira e) throws IOException {
        out.beginObject();
        out.name("identificador").value(e.getId());
        out.name("nome").value(e.getNome());
        out.name("custoDiario").value(e.getCustoDia());
        out.name("combustivel").value(e.getCombustivel());
        out.name("carga").value(e.getCarga());
        out.name("equipe").value(e.getEquipe().getCodinome());
        out.name("tipo").value(3);
        out.endObject();
    }

    @Override
    public Escavadeira read(JsonReader in) throws IOException {
        return null;
    }
}
