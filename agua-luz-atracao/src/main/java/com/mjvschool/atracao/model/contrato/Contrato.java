package com.mjvschool.atracao.model.contrato;


import java.time.LocalDateTime;

import com.mjvschool.atracao.model.cadastro.NotificacaoTipo;
import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;

//java beans
public class Contrato {
	private long numeroProtocolo;
	private Pessoa cadastro;
	private LocalDateTime dataHora;
	private Servico servico;
	private NotificacaoTipo notiTipo;

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public NotificacaoTipo getNotiTipo() {
		return notiTipo;
	}

	public void setNotiTipo(NotificacaoTipo notiTipo) {
		this.notiTipo = notiTipo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}


	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public long getNumeroProtocolo() {
		return numeroProtocolo;
	}
	public void setNumeroProtocolo(long numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	public Pessoa getCadastro() {
		return cadastro;
	}
	public void setCadastro(Pessoa cadastro) {
		this.cadastro = cadastro;
	}
	@Override
	
	public String toString() {
		return "Contrato [numeroProtocolo=" + numeroProtocolo + ", dataHora=" + dataHora + "]";
	}
	
	
}
