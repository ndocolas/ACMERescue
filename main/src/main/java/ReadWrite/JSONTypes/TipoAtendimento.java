package ReadWrite.JSONTypes;

import Atendimento.Atendimento;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;


public class TipoAtendimento extends TypeAdapter<Atendimento> {

    @Override
    public void write(JsonWriter out, Atendimento at) throws IOException {
        out.beginObject();
        out.name("codigo").value(at.getCodinome());
        out.name("dataInicio").value(at.getData());
        out.name("duracao").value(at.getDuracao());
        out.name("evento").value(at.getEvento().getCodigo());
        if(at.getEquipeAlocada() != null) out.name("equipe").value(at.getEquipeAlocada().getCodinome());
        out.endObject();
    }

    @Override
    public Atendimento read(JsonReader in) throws IOException {
        return null;
    }
}
