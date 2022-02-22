package notification.service;

import notification.model.contrato.Contrato;

public class ContratoService {
	public String gerarConteudoContrato(Contrato contrato){
		//power classes
        
		StringBuilder cs = new StringBuilder();
		cs.append("Senhor(a)").append(contrato.getCadastro().getPessoa().getNome()).append(" Informamos que conforme o contrato com protocolo de número ").append(contrato.getNumeroProtocolo());
		
		return cs.toString();
		/*
		String texto = "";
		texto = texto + "Senhor(a) " + contrato.getCadastro().getPessoa().getNome();
		texto = texto + " Informamos que conforme contrato com protocolo de número " + contrato.getNumeroProtocolo();
		return texto;
		*/
	}
}
