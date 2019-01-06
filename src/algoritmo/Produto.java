package algoritmo;

public class Produto {
	private String nome;
	private Double espa�o;
	private Double valor;

	public Produto(String nome, Double espa�o, Double valor) {
		this.nome = nome;
		this.valor = valor;
		this.espa�o = espa�o;
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

	public Double getEspa�o() {
		return espa�o;
	}

	public void setEspa�o(Double espa�o) {
		this.espa�o = espa�o;
	}

}
