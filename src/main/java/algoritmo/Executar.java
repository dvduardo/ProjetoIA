package algoritmo;

import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.List;

public class Executar {

    public static void main(String[] args) {

        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto("Geladeira Dako", 0.751, 999.90));
        listaProdutos.add(new Produto("Iphone 6", 0.000089, 2911.12));
        listaProdutos.add(new Produto("TV 55", 0.400, 4346.99));
        listaProdutos.add(new Produto("TV 50", 0.290, 3999.90));
        listaProdutos.add(new Produto("TV 42", 0.200, 2999.00));
        listaProdutos.add(new Produto("Notebook Dell", 0.00350, 2499.90));
        listaProdutos.add(new Produto("Ventilador Panasonic", 0.496, 199.90));
        listaProdutos.add(new Produto("Microondas Eletrolux", 0.0424, 308.66));
        listaProdutos.add(new Produto("Microondas LG", 0.0544, 429.90));
        listaProdutos.add(new Produto("Microondas Panasonic", 0.0319, 299.29));
        listaProdutos.add(new Produto("Geladeira Brastemp", 0.635, 849.00));
        listaProdutos.add(new Produto("Geladeira Consul", 0.870, 1199.89));
        listaProdutos.add(new Produto("Notebook Lenovo", 0.498, 1999.90));
        listaProdutos.add(new Produto("Notebook Asus", 0.527, 3999.00));

        List<Object> espacos = new ArrayList<>();
        List<Object> valores = new ArrayList<>();
        List<Object> nomes = new ArrayList<>();

        for (Produto produto : listaProdutos) {
            espacos.add(produto.getEspaco());
            valores.add(produto.getValor());
            nomes.add(produto.getNome());
        }

        Double limite = 4.0;

        int tamanhoPopulacao = 5;
        int numeroGeracoes = 400;
        Double probalbilidadeMutacao = 0.05;

        AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
        List resultado = ag.resolver(probalbilidadeMutacao, numeroGeracoes, espacos, valores, limite);

        for (int i = 0; i < listaProdutos.size(); i++) {
            if (resultado.get(i).equals("1")) {
                System.out.println("Nome: " + listaProdutos.get(i).getNome());
            }
        }

        Grafico g = new Grafico("Algoritmo Genetico", "Evolucao das solucoes", ag.getMelhoresCromossomos());
        g.pack();
        RefineryUtilities.centerFrameOnScreen(g);
        g.setVisible(true);

    }

}
