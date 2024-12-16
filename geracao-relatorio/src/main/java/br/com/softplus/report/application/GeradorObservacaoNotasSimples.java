package br.com.softplus.report.application;

import java.util.List;
import java.util.stream.Collectors;

public class GeradorObservacaoNotasSimples implements  IGeraObservacao<Integer>{

	public String montarCodigos(List<Integer> notas) {
		List<String> itens = (List<String>) notas.stream().map(String::valueOf).collect(Collectors.toList());

		if (notas.size() >= 2) {
			String ultimo = itens.remove(itens.size() - 1);
			return String.join(", ", itens) + " e " + ultimo;
		} else {
			return itens.get(0);
		}

	}
}
