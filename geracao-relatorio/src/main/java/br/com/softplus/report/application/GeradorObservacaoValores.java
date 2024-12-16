package br.com.softplus.report.application;

import java.util.List;
import java.util.stream.Collectors;

import br.com.softplus.report.model.NotaFiscal;

public class GeradorObservacaoValores implements IGeraObservacao<NotaFiscal> {
 
	
	//1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30
	public String montarCodigos(List<NotaFiscal> notas) {
		
		List<String> itens = (List<String>) notas.stream().map(NotaFiscal::toString).collect(Collectors.toList());


		if (notas.size() >= 2) {
			String ultimo = itens.remove(itens.size() - 1);
			return String.join(", ", itens) + " e " + ultimo;
		} else {
			return itens.get(0);
		}

	}
}
