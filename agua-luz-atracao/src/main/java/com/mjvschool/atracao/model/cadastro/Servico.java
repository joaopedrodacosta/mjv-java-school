package main.java.com.mjvschool.atracao.model.cadastro;

public enum Servico {
	AGUA("Água",137.21, "A"),
	LUZ("Luz",132.15, "L");
	
	private String nome;
	private Double valor;
	private String siglaServico;

	private Servico(String nome, Double valor, String siglaServico) {
		this.nome = nome;
		this.valor = valor;
		this.siglaServico = siglaServico;
	}


	public String getSiglaServico() {
		return siglaServico;
	}
	


	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}
	
}
