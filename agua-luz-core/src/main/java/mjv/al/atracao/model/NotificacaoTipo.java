package mjv.al.atracao.model;

public enum NotificacaoTipo {
	SMS("SMS", "S"),
    WHATS("WhatsApp", "W");

    private String descricao;
    private String sigla;

    private NotificacaoTipo(String descricao, String sigla){
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }
    public static NotificacaoTipo buscarPorSigla(String sigla) {
		if(sigla.equals("S"))
			return SMS;
		else
			return WHATS;
	}
}
