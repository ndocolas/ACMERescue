package ReadWrite.JSONTypes;

import Equipe.Equipe;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class TipoEquipe extends TypeAdapter<Equipe> {

    @Override
    public void write(JsonWriter out, Equipe equipe) throws IOException {
        out.beginObject();
        out.name("codinome").value(equipe.getCodinome());
        out.name("quantidade").value(equipe.getQuantidade());
        out.name("latitude").value(equipe.getLatitude());
        out.name("longitude").value(equipe.getLongitude());
        out.endObject();
    }

    @Override
    public Equipe read(JsonReader in) throws IOException {
        return null;
    }
}
