package Eventos.Tipos;

import Eventos.Evento;

public class Seca extends Evento {

	private int estiagem;

	public Seca(String codigo, String data, double latitude, double longitude,
	 int estiagem) {
		super(codigo, data, latitude, longitude);
		this.estiagem = estiagem;
	 }
        
        public int getEstiagem() {return estiagem;}

	 @Override
	 public String getDescricao() {
		return "\n   Tipo: Seca " +
		"\n   Codigo: " + super.getCodigo() +
		"\n   Data: " + super.getData() +
		"\n   Latitude: " + super.getLatitude() +
		"\n   Longitude: " + super.getLongitude() +
		"\n   Estiagem: " + estiagem+ "\n";
	 }


}
