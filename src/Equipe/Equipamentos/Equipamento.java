package Equipe.Equipamentos;
public abstract class Equipamento {

	private int id;
	private String nome;
	private double custoDia;
	private boolean isAdded;

	public Equipamento(int id, String nome, double custoDia) {
		this.id = id;
		this.nome = nome;
		this.custoDia = custoDia;
		isAdded = false;
	}

	public int getId() {return id;}
	public String getNome() {return nome;}
	public double getCustoDia() {return custoDia;}
	public boolean getIsAdded() {return isAdded;}
	public void setIsAdded() {isAdded = true;}

	public abstract String getInfo();
	public abstract String getDescricao();
}
