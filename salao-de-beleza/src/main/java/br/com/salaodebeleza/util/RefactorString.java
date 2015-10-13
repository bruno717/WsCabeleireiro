package br.com.salaodebeleza.util;

public class RefactorString {
	
	public static String refactorTel(String telefone){
		telefone = telefone.replace("(", "");
		telefone = telefone.replace(")", "");
		telefone = telefone.replace(" ", "");
		telefone = telefone.replace("-", "");
		return telefone;
	}

}
