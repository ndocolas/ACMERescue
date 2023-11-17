/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReadWrite.JSONTypes;

import Atendimento.Atendimento;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 *
 * @author nico
 */
public class TipoAtendimento extends TypeAdapter<Atendimento> {

    @Override
    public void write(JsonWriter out, Atendimento at) throws IOException {
        out.beginObject();
        out.name("codigo").value(at.getCodinome());
        out.name("dataInicio").value(at.getData());
        out.name("duracao").value(at.getDuracao());
        out.name("status").value(at.getStatus());
        out.name("evento").value(at.getEvento().getCodigo());
        out.endObject();
    }

    @Override
    public Atendimento read(JsonReader in) throws IOException {
        return null;
    }
}
