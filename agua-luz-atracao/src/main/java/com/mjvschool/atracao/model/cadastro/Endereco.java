package main.java.com.mjvschool.atracao.model.cadastro;

public class Endereco {
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	public String getLogradouro() {
		return logradouro;
	}
	public String getUF() {
		return uf;
	}
	public void setUF (String uf) {
		this.uf = uf;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
}
