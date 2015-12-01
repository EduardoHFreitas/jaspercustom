package br.univel.customlista;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class AlunoJasperDs implements JRDataSource {

	private Iterator<Aluno> iterator;
	private Aluno selecionado;

	public AlunoJasperDs(List<Aluno> lista) {
		this.iterator = lista.iterator();
	}

	public Object getFieldValue(JRField arg0) throws JRException {

		if ("id".equals(arg0.getName())) {
			return selecionado.getId();
		}

		if ("nome".equals(arg0.getName())) {
			return selecionado.getNome();
		}

		if ("telefone".equals(arg0.getName())) {
			return selecionado.getTelefone();
		}

		return null;
	}

	public boolean next() throws JRException {

		if (iterator.hasNext()) {
			selecionado = iterator.next();
			return true;
		}

		return false;
	}

}
