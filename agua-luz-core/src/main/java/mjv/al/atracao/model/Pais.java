package mjv.al.atracao.model;

public enum Pais {
	BR ("Brasil") ,
	PE ("Peru") ,
	US ("Estados Unidos") ;
	
	private String nome;
	
	private Pais(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

}
