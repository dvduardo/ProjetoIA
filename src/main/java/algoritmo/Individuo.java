package algoritmo;

import java.util.ArrayList;
import java.util.List;

public class Individuo implements Comparable<Individuo>{
	private List<Object> espacos;
	private List<Object> valores;
	private Double limiteEspaco;
	private Double notaAvaliacao;
	private Double espacoUsado;
	private int geracao;
	private List<Object> cromossomo = new ArrayList<>();

	public Individuo(List<Object> espacos, List<Object> valores, Double limiteEspaco) {
		this.espacos = espacos;
		this.valores = valores;
		this.limiteEspaco = limiteEspaco;
		this.notaAvaliacao = 0.0;
		this.espacoUsado = 0.0;
		this.geracao = 0;

		for (int i = 0; i < this.espacos.size(); i++) {
			if (java.lang.Math.random() < 0.5)
				this.cromossomo.add("0");
			else
				this.cromossomo.add("1");
		}
	}

	/**
	 * Calcula a o preco total da carga e o gasto de espaco do caminhao
	 */

	public void avaliacao() {
		Double nota = 0.0;
		Double somaEspacos = 0.0;
		for (int i = 0; i < this.cromossomo.size(); i++) {
			if (this.cromossomo.get(i).equals("1")) {
				nota += (Double) this.valores.get(i);
				somaEspacos += (Double) this.espacos.get(i);
			}
		}
		if (somaEspacos > this.limiteEspaco) {
			somaEspacos= -1.0;
		}

		this.notaAvaliacao = nota;
		this.espacoUsado = somaEspacos;
	}

	/**
	 * Fara um crossover entre dois individuos mesclando seus cromossomos entre 2
	 * filhos e formando uma nova geracao.
	 * 
	 * @param outroIndividuo Individou a qual quer fazer o crossover
	 * @return Os filhos gerados da mesclagem dos dois individuos.
	 */

	public List<Individuo> crossover(Individuo outroIndividuo) {
		int corte = (int) Math.round(Math.random() * this.cromossomo.size());

		ArrayList<Object> filho1 = new ArrayList<>();
		filho1.addAll(outroIndividuo.getCromossomo().subList(0, corte));
		filho1.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));

		ArrayList<Object> filho2 = new ArrayList<>();
		filho2.addAll(this.cromossomo.subList(0, corte));
		filho2.addAll(outroIndividuo.getCromossomo().subList(corte, this.cromossomo.size()));

		List<Individuo> filhos = new ArrayList<>();
		filhos.add(new Individuo(this.espacos, this.valores, this.limiteEspaco));

		filhos.add(new Individuo(this.espacos, this.valores, this.limiteEspaco));

		filhos.get(0).setCromossomo(filho1);
		filhos.get(0).setGeracao(this.geracao + 1);
		filhos.get(1).setCromossomo(filho2);
		filhos.get(1).setGeracao(this.geracao + 1);

		return filhos;

	}

	/**
	 * Pega o cromossomo do Individuo e aplica uma mutacao na qual inverte um ou mais genes dependendo da taxa de mutacao.
	 * 
	 * @param taxaMutacao
	 * 			A porcentagem de ocorrer uma mutacao
	 * @return
	 * 		retorna o individuo mutado
	 */
	public Individuo mutacao(Double taxaMutacao) {
		//System.out.println("\nAntes da Mutação:  " + this.cromossomo);

		for (int i = 0; i < this.cromossomo.size(); i++) {
			if (Math.random() < taxaMutacao) {
				if (this.cromossomo.get(i).equals("1"))
					this.cromossomo.set(i, "0");
				else
					this.cromossomo.set(i, "1");
			}
		}

		//System.out.println("Depois da mutacao: " + this.cromossomo);

		return this;
	}

	public List<Object> getEspacos() {
		return espacos;
	}

	public Double getEspacoUsado() {
		return espacoUsado;
	}

	public void setEspacoUsado(Double espacoUsado) {
		this.espacoUsado = espacoUsado;
	}

	public void setEspacos(List<Object> espacos) {
		this.espacos = espacos;
	}

	public List<Object> getValores() {
		return valores;
	}

	public void setValores(List<Object> valores) {
		this.valores = valores;
	}

	public Double getLimiteEspaco() {
		return limiteEspaco;
	}

	public void setLimiteEspaco(Double limiteEspaco) {
		this.limiteEspaco = limiteEspaco;
	}

	public Double getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(Double notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public List<Object> getCromossomo() {
		return cromossomo;
	}

	public void setCromossomo(List<Object> cromossomo) {
		this.cromossomo = cromossomo;
	}

	@Override
	public int compareTo(Individuo o) {
		if (this.notaAvaliacao > o.getNotaAvaliacao() || this.espacoUsado == -1) {
			return -1;
		}
		if (this.notaAvaliacao < o.getNotaAvaliacao() || this.espacoUsado != -1) {
		return 1;
		}
		return 0;
	}

}
