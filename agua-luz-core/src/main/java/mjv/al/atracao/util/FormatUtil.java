package mjv.al.atracao.util;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatUtil {
	public static final Locale LOCALE_BR = new Locale("pt", "BR");
	public static final Locale LOCALE_US = new Locale("en", "US");
	
	public static String formatarDataHora(LocalDateTime dataHora, Locale locale) {
		Chronology chronology = Chronology.ofLocale( locale );
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ).withLocale( locale ).withChronology( chronology );
		String dataHoraFormatada = dataHora.format( formatter );
		return dataHoraFormatada;
	}
	public static String formatarHora(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	public static String formatarCpfCnpj(String cpfCnpj) {
		//claro que deveriamos validar valores inv�lidos
		cpfCnpj = cpfCnpj.replaceAll("\\D", "");
		if(cpfCnpj.length()<14)
			return cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
		else
			return cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
	}
	public static String formatarCep(String cep) {
		cep = cep.replaceAll("\\D", "");
		return cep.replaceAll("(\\d{2})(\\d{3})(\\d{3})", "$1.$2-$3");
	}
	public static String formatarTelefoneCelular(String telefone) {
		telefone = telefone.replaceAll("\\D", "");
		if(telefone.length()==10)
			return telefone.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
		else
			return telefone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
	}
	public static String formatarMoeda(Double valor, Locale locale) {
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		return format.format(valor);
	}
	

	/*
	private static final String FORMATO_DATA_BR = "dd/MM/yyyy";
	
	private static final String FORMATO_DATA_HORA_BR = "dd/MM/yyyy HH:mm";
	public static String formatarDataHora(Date data) {
		return formatarDataHora(data, FORMATO_DATA_HORA_BR);
	}
	public static String formatarData(Date data) {
		return formatarDataHora(data, FORMATO_DATA_BR);
	}
	public static String formatarDataHora(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern(FORMATO_DATA_HORA_BR));
	}
	public static String formatarData(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern(FORMATO_DATA_BR));
	}
	
	public static String formatarDataHora(Date data, String formato) {
		SimpleDateFormat formatador = new SimpleDateFormat(formato);
		String dataFormatada = formatador.format(data);
		return dataFormatada;
	}
	public static String formatarDataHora(LocalDateTime data, String formato) {
		return data.format(DateTimeFormatter.ofPattern(formato));
	}
	
	public static String formatarHora(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	*/
	
	/*
	public static void main(String[] args) {
		Date dataAtual = new Date();
		System.out.println(formatarDataHora(dataAtual, "yyyy-MM-dd HH:mm:ss"));
		System.out.println(formatarDataHora(dataAtual));
		System.out.println(formatarData(dataAtual));
		System.out.println(formatarCpfCnpj("41230344039"));
		System.out.println(formatarCpfCnpj("83751649000171"));
		System.out.println(formatarCep("65300080"));
		System.out.println(formatarTelefoneCelular("1133450912"));
		System.out.println(formatarTelefoneCelular("11943987509"));
		
		Double valor = 1234.56;
		
		System.out.println(formatarMoeda(valor, new Locale("en", "US")));
		System.out.println(formatarMoeda(valor, new Locale("pt", "BR")));
		
	}
	*/
}
