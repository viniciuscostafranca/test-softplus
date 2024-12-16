package br.com.softplus.report.application;

import java.util.List;

public interface IGeraObservacao<T> {

	 String montarCodigos(List<T> notas);

}
