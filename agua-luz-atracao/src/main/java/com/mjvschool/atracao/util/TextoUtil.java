package com.mjvschool.atracao.util;



public class TextoUtil {
	public static String formatarNome(String tipo, String textoOriginal) {
		StringBuilder nomef = new StringBuilder();

		if(tipo.equalsIgnoreCase("nome")){
		nomef.append(textoOriginal);
		nomef.setLength(30);
		}
		
		if(tipo.equalsIgnoreCase("Logradouro")){
		nomef.append(textoOriginal);
		nomef.setLength(20);
		
	}
		if(tipo.equalsIgnoreCase("Complemento")){
		nomef.append(textoOriginal);
		nomef.setLength(10);
	}

	if(tipo.equalsIgnoreCase("Bairro")){
		nomef.append(textoOriginal);
		nomef.setLength(15);

	}

	
	  return nomef.toString();

  }
}

	
	
	/*
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}
	*/

