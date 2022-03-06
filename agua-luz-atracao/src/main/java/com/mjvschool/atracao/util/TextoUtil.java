package com.mjvschool.atracao.util;



public class TextoUtil {

	

	public static String caixaAlta(String textoOriginal){
		return textoOriginal.toUpperCase();
	

	}

	public static String retirarCaracteresEspeciais(String textoOriginal){
		return textoOriginal.replaceAll("\\D", "");
		

	}

	public static String preencher(String textoOriginal, int tamanhoMaximo) {
		String formato = "%-" + tamanhoMaximo + "s";
		String novaString = String.format(formato, textoOriginal);
		return novaString;
	}
	public static String cortar(String textoOriginal, int tamanhoMaximo) {
		String  novaString = textoOriginal.substring(0, Math.min(tamanhoMaximo, textoOriginal.length()));
		return novaString;
	}

	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}
	
}
	/*
	public String limitaString(String testes, int tamanho){        
        if(testes != null && testes.length() > tamanho){            
            return testes.substring(0, tamanho+1) + "...";
        } else {
            return testes;
        }        
    }
	/*
	public static String limitarTamanho(String textoOriginal, int tamanho) {

		//alterar uso do stringbuilder -- Testar substring
		return textoOriginal.substring(0, tamanho);
		
	}
	*/

