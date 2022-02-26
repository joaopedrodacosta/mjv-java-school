package com.mjvschool.atracao.util;



public class TextoUtil {
	public static String formatarNome(String tipo, String textoOriginal) {
		StringBuilder nomef = new StringBuilder();

		if(tipo.equalsIgnoreCase("nome")){
		nomef.append(textoOriginal);
		nomef.setLength(30);
		}
		
		if(tipo.equalsIgnoreCase("logradouro")){
		nomef.append(textoOriginal);
		nomef.setLength(20);
		
	}
		if(tipo.equalsIgnoreCase("complemento")){
		nomef.append(textoOriginal);
		nomef.setLength(10);
	}

	if(tipo.equalsIgnoreCase("bairro")){
		nomef.append(textoOriginal);
		nomef.setLength(15);

	}

	if(tipo.equalsIgnoreCase("cidade")){
		nomef.append(textoOriginal);
		nomef.setLength(30);

	}

	
	  return nomef.toString().toUpperCase();

  }
}

	
	
	/*
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}
	*/

