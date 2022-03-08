package mjv.al.atracao.model;

import java.time.LocalDateTime;

public class Contrato {
	private Long numeroProtocolo;
	private Pessoa pessoa;
	private LocalDateTime dataHora;
	private Servico servico;
	private NotificacaoTipo notificacaoTipo;

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public Long getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(Long numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public NotificacaoTipo getNotificacaoTipo() {
		return notificacaoTipo;
	}

	public void setNotificacaoTipo(NotificacaoTipo notificacaoTipo) {
		this.notificacaoTipo = notificacaoTipo;
	}

	@Override
	public String toString() {
		return "Contrato [numeroProtocolo=" + numeroProtocolo + ", pessoa=" + pessoa + ", dataHora=" + dataHora
				+ ", servico=" + servico + ", notificacaoTipo=" + notificacaoTipo + "]";
	}

	

}
