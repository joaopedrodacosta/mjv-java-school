
package com.mjvschool.atracao.app;

import com.mjvschool.atracao.model.cadastro.Endereco;
import com.mjvschool.atracao.model.cadastro.NotificacaoTipo;
import com.mjvschool.atracao.model.cadastro.Pais;
import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;
import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.output.GeradorArquivo;
import com.mjvschool.atracao.repository.ContratoRepository;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;


public class AguaLuzAtracaoApp {
	private static ContratoRepository contratoRepositorio = new ContratoRepository();
	public static void main(String[] args) throws ParseException {
		faseAtracao();
		faseGeracaoArquivo();
	}
	private static void faseGeracaoArquivo() throws ParseException {
		List<Contrato> contratos =  contratoRepositorio.listarTodos();
		GeradorArquivo gerador = new GeradorArquivo();
		gerador.gerarArquivoCsv(contratos);
		gerador.gerarArquivoTxt(contratos);
		
		
	}
	private static void faseAtracao() {
		Contrato contrato1 = new Contrato();
		contrato1.setNumeroProtocolo(78678);
		contrato1.setServico(Servico.LUZ);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("567.372.840-94");
		pessoa.setNome("Gleyson Sampaio de Oliveiraa");
		pessoa.setRg("89789");
		pessoa.setPais(Pais.BRASIL);
		
		pessoa.setCelular("(98)96549-8760");
		
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Santo Antonio");
		endereco.setCep("27.310.657");
		endereco.setCidade("São Paulo");
		endereco.setUF("Sp");
		endereco.setLogradouro("Rua das Cajazeiras 26");
		endereco.setNumero("243");
		endereco.setComplemento("Ap 210 Bl Centauro");
		pessoa.setEndereco(endereco);
		contrato1.setCadastro(pessoa);
		contrato1.setDataHora(LocalDateTime.now());
		contrato1.setNotiTipo(NotificacaoTipo.SMS);
		contratoRepositorio.gravar(contrato1);
		
		Contrato contrato2 = new Contrato();
		contrato2.setNumeroProtocolo(1984365);
		contrato2.setServico(Servico.AGUA);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setCpf("110.949.860-89");
		pessoa2.setNome("Raimundo Nonato Loureiro Castelo Branco");
		pessoa2.setRg("98908");
		pessoa2.setPais(Pais.ESTADOS_UNIDOS);
		
		pessoa2.setCelular("(11)97634-9678");
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Santo Antonio");
		endereco2.setCep("27.310.657");
		endereco2.setCidade("São Paulo");
		endereco2.setUF("Sp");
		endereco2.setLogradouro("Rua das Marias");
		endereco2.setNumero("243");
		endereco2.setComplemento("Ap 150 Bl Centauro");
		pessoa2.setEndereco(endereco2);
		contrato2.setCadastro(pessoa2);
		contrato2.setDataHora(LocalDateTime.now());
		contrato2.setNotiTipo(NotificacaoTipo.WHATS);
		
		contratoRepositorio.gravar(contrato2);
	}
}
