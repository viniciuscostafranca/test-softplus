package br.com.softplus.report.application;

import java.util.List;
import java.util.stream.Collectors;

import br.com.softplus.report.model.NotaFiscal;
import br.com.softplus.report.util.DicionarioDeMensagens;

public class GeradorObservacao  {
	

	// Gera observações, com texto pre-definido, incluindo os números, das notas
	// fiscais, recebidos no parâmetro
	public String geraObservacao(List<Integer> notas) {
		if (!notas.isEmpty()) {
			return montarObservacao(notas , new GeradorObservacaoNotasSimples()) ;
		}
		return "";
	}
	
	public String geraObservacaoValores(List<NotaFiscal> notas) {
		if (!notas.isEmpty()) {
			return montarObservacao(notas, new GeradorObservacaoValores()) ;
		}
		return "";
	}

	// Cria observação
	private String montarObservacao(List notas, IGeraObservacao geraObservacao ) {

		String mensagemInicial = montarMensagemInicial(notas);

		String codigos = montarCodigos(notas);
		//String codigos = geraObservacao.montarCodigos(notas);

		return mensagemInicial + codigos+".";
	}

	private String montarMensagemInicial(List notas) {
		String mensagemInicial;

		if (notas.size() >= 2) {
			mensagemInicial = DicionarioDeMensagens.UMAS_NOTA;
		} else {
			mensagemInicial = DicionarioDeMensagens.UMA_NOTA;
		}
		return mensagemInicial;
	}

	private String montarCodigos(List notas) {
		List<String> itens = (List<String>) notas.stream().map(String::valueOf).collect(Collectors.toList());

		if (notas.size() >= 2) {
			String ultimo = itens.remove(itens.size() - 1);
			return String.join(", ", itens) + " e " + ultimo;
		} else {
			return itens.get(0);
		}

	}


}