package mjv.al.atracao.service;

import java.util.Locale;

import mjv.al.atracao.model.Contrato;
import mjv.al.atracao.model.Endereco;
import mjv.al.atracao.model.Pais;
import mjv.al.atracao.model.Pessoa;
import mjv.al.atracao.model.Servico;
import mjv.al.atracao.util.FormatUtil;

public class ContratoService {
	public String gerarConteudoContrato(Contrato contrato){
		//power classes
		Locale locale = definirLocalePorPais(contrato.getPessoa().getPais());
		System.out.println("LOCALE->" + locale);
		StringBuilder conteudo = new StringBuilder();
		Pessoa pessoa = contrato.getPessoa();
		conteudo.append("Senhor(a) ".concat(pessoa.getNome()).concat(" cpf de número ").concat(FormatUtil.formatarCpfCnpj(pessoa.getCpf())).concat("\n"));
		conteudo.append("Informamos que conforme contrato com protocolo de número " + contrato.getNumeroProtocolo());
		String dataHoraFormatada = FormatUtil.formatarDataHora(contrato.getDataHora(),locale);
		conteudo.append(" está agendado para a data "  + dataHoraFormatada);
		
		Servico servico = contrato.getServico();
		
		//String.format entrando em ação
		conteudo.append(String.format(" a instalação do serviço de %s com taxa de valor %s", servico.getNome(), FormatUtil.formatarMoeda(servico.getValor(), locale) ));
		conteudo.append(" em sua residência no endereço abaixo:\n\n");
		
		Endereco end = contrato.getPessoa().getEndereco();
		
		conteudo.append(String.format("Logradouro: %s\n", end.getLogradouro()));
		conteudo.append(String.format("Complemento: %s\n", end.getComplemento()));
		conteudo.append(String.format("Bairro: %s\n", end.getBairro()));
		conteudo.append(String.format("Cidade: %s / %s\n", end.getCidade(),end.getEstado()));
		conteudo.append(String.format("Cep: %s\n", FormatUtil.formatarCep(end.getCep())));
		
		return conteudo.toString();
	}
	//poderia ser em uma classe converter utils
	private Locale definirLocalePorPais(Pais pais) {
		if(pais == Pais.BR)
			return FormatUtil.LOCALE_BR;
		else
			return FormatUtil.LOCALE_US;
		
		//else if(pais == Pais.ESTADOS_UNIDOS)
			//return new Locale("en", "US");
	
	}
}
