package com.mjvschool.atracao.output;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import com.mjvschool.atracao.model.cadastro.Endereco;
import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.util.FormatUtil;
import com.mjvschool.atracao.util.TextoUtil;

public class GeradorArquivo {
	public void gerarArquivoCsv(List<Contrato> contratos) {
		StringBuilder conteudo =new StringBuilder();
		for(Contrato ct: contratos) {
			conteudo.append(ct.getCadastro().getNome());
			conteudo.append(";").append(ct.getCadastro().getCpf());
			conteudo.append(";").append(ct.getCadastro().getCelular());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getLogradouro());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getNumero());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getComplemento());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getBairro());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getCidade());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getUF());
			conteudo.append(";").append(ct.getCadastro().getEndereco().getCep());
			conteudo.append(";").append(ct.getNumeroProtocolo());
			conteudo.append(";").append(ct.getDataHora());
			conteudo.append(";").append(ct.getServico().getSiglaServico());
			conteudo.append(";").append(ct.getServico().getValor());
			conteudo.append(";").append(ct.getNotiTipo().getNome());
			conteudo.append("\n");
		}
		
		System.out.println(conteudo.toString());
		
		File output = new File("C:\\estudo\\mjv-java-school\\agua-luz-output");
		if(!output.exists())
			output.mkdirs();
		
		Path path = Paths.get("C:\\estudo\\mjv-java-school\\agua-luz-output\\agua-luz-contratos.csv");

		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void gerarArquivoTxt(List<Contrato> contratos) throws ParseException {
		StringBuilder conteudo =new StringBuilder();
		
		for(Contrato ct: contratos) {

			Pessoa pessoa = ct.getCadastro(); 
			Endereco endereco = pessoa.getEndereco();
	         
			conteudo.append(TextoUtil.ajustar(pessoa.getNome(), 30).toUpperCase());
			conteudo.append(TextoUtil.ajustar(TextoUtil.retirarCaracteresEspeciais(pessoa.getCpf()), 11));
			conteudo.append(TextoUtil.ajustar(TextoUtil.retirarCaracteresEspeciais(pessoa.getCelular()), 11));
			conteudo.append(TextoUtil.ajustar(endereco.getLogradouro(), 20).toUpperCase());
			conteudo.append(FormatUtil.formatarNumEndereco(endereco.getNumero()));
			conteudo.append(TextoUtil.ajustar(endereco.getComplemento(), 10).toUpperCase()); 
			conteudo.append(TextoUtil.ajustar(endereco.getBairro(), 15).toUpperCase());   
			conteudo.append(TextoUtil.ajustar(endereco.getCidade(), 30).toUpperCase()); 
			conteudo.append(TextoUtil.ajustar(endereco.getUF(), 2).toUpperCase()).append(" ");
			conteudo.append(TextoUtil.ajustar(TextoUtil.retirarCaracteresEspeciais(endereco.getCep()), 8));
			conteudo.append(FormatUtil.formatarProtoc(ct.getNumeroProtocolo()));
			conteudo.append(FormatUtil.formatarDataHora(ct.getDataHora(), "ddMMyyyy HHmm"));
			conteudo.append(ct.getServico().getSiglaServico());
			conteudo.append(TextoUtil.retirarCaracteresEspeciais(FormatUtil.formatarValor(ct.getServico().getValor(), "000000.##")));
			conteudo.append(ct.getNotiTipo().getSiglaNotificacao()).append("\n");
			
		}
		
		System.out.println(conteudo.toString());
		
		//pode-se criar um único método para gerar os arquivos
		File output = new File("C:\\estudo\\mjv-java-school\\agua-luz-output");
		if(!output.exists())
			output.mkdirs();
		
		Path path = Paths.get("C:\\estudo\\mjv-java-school\\agua-luz-output\\agua-luz-contratos.txt");

		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void gerarArquivoContrato(List<Contrato> contratos) throws ParseException {
		
		
		for(Contrato ct: contratos) {

			StringBuilder conteudo =new StringBuilder();
			String dataHoraMasc = "";
			String valorMasc = "";
			Pessoa pessoa = ct.getCadastro();
			Endereco endereco = pessoa.getEndereco(); 

			//adicionando máscaras de formatação de acordo com o país
			if(pessoa.getPais().getNome().equalsIgnoreCase("Brasil")){
				dataHoraMasc = "dd/MM/yyyy HH:mm ";
				valorMasc = "######,##";
			}

			if(pessoa.getPais().getNome().equalsIgnoreCase("Peru")){
				 dataHoraMasc = "dd/MM/yyyy HH:mm";
				 valorMasc = "######,##";
			}
			if(pessoa.getPais().getNome().equalsIgnoreCase("Estados Unidos")){
				 dataHoraMasc = "yyyy/MM/dd hh:mm a";
				 valorMasc = "######.##";
			}

			//gerando a mensagem
			conteudo.append("Senhor(a) ").append((pessoa.getNome())).append(" cpf de número ").append((pessoa.getCpf()));
			conteudo.append(", Informamos que conforme contrato com protocolo de número ").append(ct.getNumeroProtocolo());
			conteudo.append(" está agendado para a data ").append(FormatUtil.formatarDataHora(ct.getDataHora(), dataHoraMasc));
			conteudo.append(" a instalação do serviço de ").append(ct.getServico().getNome()).append(" com taxa de valor R$ ");
			conteudo.append(FormatUtil.formatarValor(ct.getServico().getValor(), valorMasc)).append("em sua residência localizada no endereço abaixo:").append("\n");
			conteudo.append("Logradouro: ").append(endereco.getLogradouro()).append(", ").append(endereco.getNumero()).append("\n");
			conteudo.append("Complemento: ").append((endereco.getComplemento())).append("\n");
			conteudo.append("Bairro: ").append(endereco.getBairro()).append("\n");
			conteudo.append("Cidade: ").append(endereco.getCidade()).append("/").append(endereco.getUF()).append("\n");
			conteudo.append("Cep: ").append(endereco.getCep());

		
		File output = new File("C:\\estudo\\mjv-java-school\\agua-luz-output");
		if(!output.exists())
			output.mkdirs();

		//criando arquivos de acordo com o número dos protocolos 
		Path path = Paths.get("C:\\estudo\\mjv-java-school\\agua-luz-output\\contrato-" + ct.getNumeroProtocolo() + ".txt");

		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	*/
}
