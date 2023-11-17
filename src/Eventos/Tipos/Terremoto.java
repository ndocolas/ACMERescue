package Eventos.Tipos;

import Eventos.Evento;

public class Terremoto extends Evento {
	private double magnitude;

	public Terremoto(String codigo, String data, double latitude, double longitude, double magnitude) {
		super(codigo, data, latitude, longitude);
		this.magnitude = magnitude;
	}

        public double getMagnitude() {return magnitude;}
        
	@Override
	public String getDescricao() {
		return "\n   Tipo: Terremoto " +
            "\n   Codigo: " + super.getCodigo() +
            "\n   Data: " + super.getData() +
			"\n   Latitude: " + super.getLatitude() +
			"\n   Longitude: " + super.getLongitude() +
			"\n   Magnitutde: " + magnitude+ "\n";
	}
	
}