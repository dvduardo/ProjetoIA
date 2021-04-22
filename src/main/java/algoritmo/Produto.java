package algoritmo;

public class Produto {
	private String nome;
	private Double espaco;
	private Double valor;

	public Produto(String nome, Double espaco, Double valor) {
		this.nome = nome;
		this.valor = valor;
		this.espaco = espaco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getEspaco() {
		return espaco;
	}

	public void setEspaco(Double espaco) {
		this.espaco = espaco;
	}

}
