package com.mjvschool.atracao.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TextoUtil {
	public static String formatarNome(String textoOriginal) {
		StringBuilder nomef = new StringBuilder();
		nomef.append(textoOriginal);
		nomef.setLength(30);
		return nomef.toString();
	}
	
	public static String formatarData(Date data) {

        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
        String formatado = sdf.format(data); 
	

		return formatado;
		
	}
	/*
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}
	*/
	public static void main(String[] args) {
		String nomeCompleto = "Gleyson Sampaio de Oliveira";
		System.out.println(formatarNome(nomeCompleto));
		Date data = new Date();
		System.out.println(formatarData(data));

	

	}
}
