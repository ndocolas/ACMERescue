package Eventos.Tipos;

import Eventos.Evento;

public class Ciclone extends Evento {

	private double velocidade;
	private double precipitacao;

	public Ciclone(String codigo, String data, double latitude, double longitude,
	double velocidade, double precipitacao) {
		super(codigo, data, latitude, longitude);
		this.velocidade = velocidade;
		this.precipitacao = precipitacao;
	}
	@Override
	public String getDescricao() {
		return "\n   Tipo: Ciclone " +
			    "\n   Codigo: " + super.getCodigo() +
				"\n   Data: " + super.getData() +
				"\n   Latitude: " + super.getLatitude() +
				"\n   Longitude: " + super.getLongitude() + 
				"\n   Velocidade Vento: " + velocidade +
				"\n   Precipitacao: " + precipitacao+ "\n";
	}

}
