package com.mjvschool.atracao.util;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtil {

    public static String formatarDataHora(LocalDateTime dataHora, String formato) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        String formatoFinal = dataHora.format(formatter); 
		return formatoFinal;
        
	}

    //subistitiu os zeros pelos números passados, se o número for menor que a máscara os zeros a esquerda sobrando permanecem
    public static String formatarProtoc(long numero) {

            DecimalFormat df = new DecimalFormat("0000000000");
            String valor = df.format(numero); 
            return valor;

    }

    //formata o valor de acordo com a máscara
    public static String formatarValor(double numero, String mascara) {

        DecimalFormat df = new DecimalFormat(mascara);
        String valor = df.format(numero); 
        return valor;

}
    
    //formata o numero preenchendo até 6 zeros a esquerda
    public static String formatarNumEndereco(String numero){
      

        String formatado = String.format("%06d", Integer.parseInt(numero));
        return formatado;
    
    }

    
    

    


    
}
