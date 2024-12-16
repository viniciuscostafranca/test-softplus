package br.com.softplus.report.util;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.List;

import br.com.softplus.report.model.NotaFiscal;

public class MocksNotasValores {
	
	public static  List<NotaFiscal> getMockNotasFiscais(){
		
		return asList(new NotaFiscal(1L, BigDecimal.valueOf(10)),
				new NotaFiscal(2L, BigDecimal.valueOf(35)),
				new NotaFiscal(3L, BigDecimal.valueOf(40)));
	}

}
