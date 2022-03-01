package com.mjvschool.atracao.util;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtil {

    public static String formatarDataHora(LocalDateTime dataHora) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        String formatoFinal = dataHora.format(formatter); 
		return formatoFinal;
        
	}

    public static String formatarCelular(String numero) throws ParseException {
 
        numero=numero.replaceAll("\\D", ""); //Removo todos os caracteres não-numéricos
        String mascara="";
        
        mascara= "###########"; 
        try{
            javax.swing.text.MaskFormatter formatadorNumero = new javax.swing.text.MaskFormatter(mascara);
            javax.swing.JFormattedTextField txtNumero = new javax.swing.JFormattedTextField(formatadorNumero);
            txtNumero.setText(numero);
            return txtNumero.getText();
    } catch (java.text.ParseException e) {
		e.printStackTrace();
		return "Inválido";
	}
    }   

    public static String formatarCpf(String numero) throws ParseException {
 
        numero=numero.replaceAll("\\D", ""); //Removo todos os caracteres não-numéricos
        String mascara="";

        mascara="###########"; 
       try{
        javax.swing.text.MaskFormatter formatadorNumero = new javax.swing.text.MaskFormatter(mascara);
        javax.swing.JFormattedTextField txtNumero = new javax.swing.JFormattedTextField(formatadorNumero);
        txtNumero.setText(numero);
        return txtNumero.getText();

    } catch (java.text.ParseException e) {
		e.printStackTrace();
		return "Inválido";
	}
}

    public static String formatarCep(String numero) throws ParseException {
 
        numero=numero.replaceAll("\\D", ""); //Removo todos os caracteres não-numéricos
        String mascara="";

        mascara="########"; 
       try{
        javax.swing.text.MaskFormatter formatadorNumero = new javax.swing.text.MaskFormatter(mascara);
        javax.swing.JFormattedTextField txtNumero = new javax.swing.JFormattedTextField(formatadorNumero);
        txtNumero.setText(numero);
        return txtNumero.getText();

    } catch (java.text.ParseException e) {
		e.printStackTrace();
		return "Inválido";
	}
}
    //pensar em uma solucão add zeros a esquerda caso o número for menor que a máscara
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
