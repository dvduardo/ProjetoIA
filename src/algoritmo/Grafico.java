package algoritmo;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
class Grafico extends ApplicationFrame {
	public Grafico(String tituloJanela, String tituloGrafico, List<Individuo> melhores) {
		super(tituloJanela);
		this.melhoresCromossomos = melhores;
		JFreeChart graficoLinha = ChartFactory.createLineChart(tituloGrafico, "Gera��o", "Valor", carregaDados(),
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel janelaGrafico = new ChartPanel(graficoLinha);
		janelaGrafico.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(janelaGrafico);
	}

	private List<Individuo> melhoresCromossomos = new ArrayList<>();

	private DefaultCategoryDataset carregaDados() {
		DefaultCategoryDataset dados = new DefaultCategoryDataset();
		for (int i = 0; i < melhoresCromossomos.size(); i++) {
			dados.addValue(melhoresCromossomos.get(i).getNotaAvaliacao(), "Melhor Solucoes", "" + i);
		}
		return dados;
	}
}
