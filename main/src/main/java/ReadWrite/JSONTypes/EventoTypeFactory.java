package ReadWrite.JSONTypes;

import Eventos.Evento;
import Eventos.Tipos.Ciclone;
import Eventos.Tipos.Seca;
import Eventos.Tipos.Terremoto;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class EventoTypeFactory implements TypeAdapterFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!Evento.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        if (Seca.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new SecaType();
        } else if (Ciclone.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new CicloneType();
        } else if (Terremoto.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new TerremotoType();
        }
        throw new IllegalArgumentException("Unrecognized type: " + type.getRawType().getName());
    }
}

class SecaType extends TypeAdapter<Seca> {
    @Override
    public void write(JsonWriter out, Seca s) throws IOException {
        out.beginObject();
        out.name("codigo").value(s.getCodigo());
        out.name("data").value(s.getData());
        out.name("latitude").value(s.getLatitude());
        out.name("longitude").value(s.getLongitude());
        out.name("tipo").value(3);
        out.name("estiagem").value(s.getEstiagem());
        out.endObject();
    }

    @Override
    public Seca read(JsonReader in) throws IOException {
        return null;
    }

}

class CicloneType extends TypeAdapter<Ciclone> {

    @Override
    public void write(JsonWriter out, Ciclone c) throws IOException {
        out.beginObject();
        out.name("codigo").value(c.getCodigo());
        out.name("data").value(c.getData());
        out.name("latitude").value(c.getLatitude());
        out.name("longitude").value(c.getLongitude());
        out.name("tipo").value(1);
        out.name("valocidade").value(c.getVelocidade());
        out.name("precipitacao").value(c.getPrecipitacao());
        out.endObject();
    }

    @Override
    public Ciclone read(JsonReader in) throws IOException {
        return null;
    }

}

class TerremotoType extends TypeAdapter<Terremoto> {

    @Override
    public void write(JsonWriter out, Terremoto t) throws IOException {
        out.beginObject();
        out.name("codigo").value(t.getCodigo());
        out.name("data").value(t.getData());
        out.name("latitude").value(t.getLatitude());
        out.name("longitude").value(t.getLongitude());
        out.name("tipo").value(3);
        out.name("magnitude").value(t.getMagnitude());
        out.endObject();
    }

    @Override
    public Terremoto read(JsonReader in) throws IOException {
        return null;
    }
}
