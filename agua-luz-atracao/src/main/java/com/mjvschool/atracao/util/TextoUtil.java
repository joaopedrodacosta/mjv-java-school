package com.mjvschool.atracao.util;



public class TextoUtil {

	

	public static String retirarCaracteresEspeciais(String textoOriginal){
		return textoOriginal.replaceAll("\\D+", "");
		

	}

	//preencher com espaços para chegar no tamanho definido
	public static String preencher(String textoOriginal, int tamanhoMaximo) {
		String formato = "%-" + tamanhoMaximo + "s";
		String novaString = String.format(formato, textoOriginal);
		return novaString;
	}

	//cortar string caso a mesma seja maior que o tamanho definido
	public static String cortar(String textoOriginal, int tamanhoMaximo) {
		String  novaString = textoOriginal.substring(0, Math.min(tamanhoMaximo, textoOriginal.length()));
		return novaString;
	}

	//preenche e corta de acordo com o tamanho passado
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}
	
}

