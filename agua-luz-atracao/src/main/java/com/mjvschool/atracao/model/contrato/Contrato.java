package com.mjvschool.atracao.model.contrato;


import java.util.Date;

import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;

//java beans
public class Contrato {
	private long numeroProtocolo;
	private Pessoa cadastro;
	private Date data;
	private Servico servico;

	
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public void setDataHora(Date data) {
		this.data = data;
	}
	public Date getDataHora() {
		return data;
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
		return "Contrato [numeroProtocolo=" + numeroProtocolo + ", dataHora=" + data + "]";
	}
	
}
