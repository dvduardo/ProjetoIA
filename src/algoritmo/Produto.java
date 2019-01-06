package algoritmo;

public class Produto {
	private String nome;
	private Double espaço;
	private Double valor;

	public Produto(String nome, Double espaço, Double valor) {
		this.nome = nome;
		this.valor = valor;
		this.espaço = espaço;
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

	public Double getEspaço() {
		return espaço;
	}

	public void setEspaço(Double espaço) {
		this.espaço = espaço;
	}

}
