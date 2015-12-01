package br.univel.customlista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleListReport {

	private String arq = "src\\main\\resources\\rel1.jasper";

	public SimpleListReport() {

		
		List<Aluno> lista = getLista(); // aqui viria do dao.
		
		
		JasperPrint jp = null;
		try {

			JRDataSource customDs = new AlunoJasperDs(lista);

			jp = JasperFillManager.fillReport(arq, null, customDs);

			JasperViewer jasperViewer = new JasperViewer(jp);

			jasperViewer.setBounds(50, 50, 320, 240);
			jasperViewer.setLocationRelativeTo(null);
			jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);

			jasperViewer.setVisible(true);

		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	private List<Aluno> getLista() {
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		for (int i = 0; i < 100; i++) {
			Aluno a = new Aluno();
			a.setId(i);
			a.setNome("Nome " +i);
			a.setTelefone("Telefone " +i);
			
			lista.add(a);
		}
		
		
		return lista;
	}

	public static void main(String[] args) {
		new SimpleListReport();
	}
}