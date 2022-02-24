package com.mjvschool.atracao.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatUtil {

    public static String formatarData(Date data) {

        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
        String formatado = sdf.format(data); 
	

		return formatado;
		
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
    
    
}
