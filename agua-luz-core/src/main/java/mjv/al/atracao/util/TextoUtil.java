package mjv.al.atracao.util;

public class TextoUtil {
	public static String preencher(String textoOriginal, int tamanhoMaximo) {
		String formato = "%-" + tamanhoMaximo + "s";
		String novaString = String.format(formato, textoOriginal);
		return novaString;
	}
	public static String limitar(String textoOriginal, int tamanhoMaximo) {
		String  novaString = textoOriginal.substring(0, Math.min(tamanhoMaximo, textoOriginal.length()));
		return novaString;
	}
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = limitar(novaString, tamanhoMaximo);
		return novaString;
	}
	//este bem hard, pois ele pode pegar qual tipo representar os digitos logo precisa ser object
	public static String completarZeros(Number valor, int comprimento) {
		Long  digitos = Long.valueOf(valor.toString().replaceAll("\\D", ""));
		String formato = "%0" + comprimento + "d";
		return String.format(formato, digitos);
	}
	
	public static void main(String[] args) {
		String nomeCompleto = "Gleyson Sampaio de Oliveira";
		System.out.println(ajustar(nomeCompleto, 30));
		
		nomeCompleto = "Raimundo Nonato Loureiro Castelo Branco";
		System.out.println(ajustar(nomeCompleto, 30));
	
		Double valor = 132.15;
		System.out.println(completarZeros(valor, 8));
		System.out.println();
	}
}
