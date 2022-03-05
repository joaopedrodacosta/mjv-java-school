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

			if(pessoa.getNome() != null && pessoa.getNome().length() > 30){            
				conteudo.append("NOME:").append(TextoUtil.limitarTamanho(pessoa.getNome(), 30).toUpperCase());
			} else {
				conteudo.append("NOME:").append(String.format("%-30s", pessoa.getNome()));
			}        
			
			conteudo.append(" CPF:").append(FormatUtil.formatarCpf(pessoa.getCpf()));
			conteudo.append(" CEL:").append(FormatUtil.formatarCelular(pessoa.getCelular()));

			Endereco endereco = pessoa.getEndereco();

			if(endereco.getLogradouro() != null && endereco.getLogradouro().length() > 20){            
				conteudo.append(" LOGRADOURO:").append(TextoUtil.limitarTamanho(endereco.getLogradouro(), 20).toUpperCase());
			} else {
				conteudo.append(" LOGRADOURO:").append(String.format("%-20s", endereco.getLogradouro()));
			}    
			
			conteudo.append(" NUMERO:").append(FormatUtil.formatarNumEndereco(endereco.getNumero()));

			if(endereco.getComplemento() != null && endereco.getComplemento().length() > 10){            
				conteudo.append(" COMPLEMENTO:").append(TextoUtil.limitarTamanho(endereco.getComplemento(), 10).toUpperCase());
			} else {
				conteudo.append(" COMPLEMENTO:").append(String.format("%-10s", endereco.getComplemento()));
			}  
			
			if(endereco.getBairro() != null && endereco.getBairro().length() > 15){            
				conteudo.append(" BAIRRO:").append(TextoUtil.limitarTamanho(endereco.getBairro(), 15).toUpperCase());
			} else {
				conteudo.append(" BAIRRO:").append(String.format("%-15s", endereco.getBairro()));
			}  
			
			if(endereco.getCidade() != null && endereco.getCidade().length() > 30){            
				conteudo.append(" CIDADE:").append(TextoUtil.limitarTamanho(endereco.getCidade(), 30).toUpperCase());
			} else {
				conteudo.append(" CIDADE:").append(String.format("%-30s", endereco.getCidade()));
			}  
			
			if(endereco.getUF() != null && endereco.getUF().length() > 2){            
				conteudo.append(" UF:").append(TextoUtil.limitarTamanho(endereco.getUF(), 2).toUpperCase());
			} else {
				conteudo.append(" UF:").append(String.format("%-2s", endereco.getUF()));
			}  
			
			
			conteudo.append(" CEP:").append(FormatUtil.formatarCep(ct.getCadastro().getEndereco().getCep()));
			conteudo.append(" PROTOCOLO:").append(FormatUtil.formatarProtoc(ct.getNumeroProtocolo()));


			conteudo.append(" DATA/HORA:").append(FormatUtil.formatarDataHora(ct.getDataHora()));
			conteudo.append(" SERVIÇO:").append(ct.getServico().getSiglaServico());
			conteudo.append(" VALOR:").append(FormatUtil.formatarValor(ct.getServico().getValor())).append("\n");
			conteudo.append("-------------------------------------------------------------");
			conteudo.append("\n");
		}
		
		System.out.println(conteudo.toString());
		
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
}
