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

    public static String formatarProtoc(long numero) {

            DecimalFormat df = new DecimalFormat("0000000000");
            String valor = df.format(numero); 
            return valor;

    }

    public static String formatarValor(double numero) {

        
        DecimalFormat df = new DecimalFormat("000000.##");
        String valor = df.format(numero); 
        valor = valor.replaceAll("\\D+","");
        return valor;

}
    
    public static String formatarNumEndereco(String numero){
      

        String formatado = String.format("%06d", Integer.parseInt(numero));
        return formatado;
    
    }
    

    


    
}
