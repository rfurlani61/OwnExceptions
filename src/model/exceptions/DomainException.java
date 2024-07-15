package model.exceptions;

public class DomainException extends RuntimeException {
/*
 * Exception -> Obriga o programa a tratar a exceção ou lançar  o erro para que programas o tratem.
 * RuntimeException -> Retira essa obrigação o que pode levar a error de execução, mas por outro lado 
 * podemos capturar erros genéricos de runtime.
 */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
