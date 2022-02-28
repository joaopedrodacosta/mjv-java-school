package com.mjvschool.atracao.output;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;


import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.util.FormatUtil;
import com.mjvschool.atracao.util.TextoUtil;

public class GeradorArquivo {
	public void gerarArquivoCsv(List<Contrato> contratos) {
		StringBuilder conteudo =new StringBuilder();
		for(Contrato ct: contratos) {
			conteudo.append(ct.getCadastro().getNome().concat(";").concat(ct.getCadastro().getCpf()));
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
			conteudo.append(FormatUtil.formatarCpf(ct.getCadastro().getCpf())).append("\n");
			conteudo.append(TextoUtil.formatarNome("nome", ct.getCadastro().getNome())).append("\n");
			conteudo.append(FormatUtil.formatarData(ct.getDataHora())).append("\n");
			conteudo.append(TextoUtil.formatarNome("logradouro", ct.getCadastro().getEndereco().getLogradouro())).append("\n");
			//numero
			conteudo.append(TextoUtil.formatarNome("complemento", ct.getCadastro().getEndereco().getComplemento())).append("\n");
			conteudo.append(TextoUtil.formatarNome("bairro", ct.getCadastro().getEndereco().getBairro())).append("\n");
			conteudo.append(TextoUtil.formatarNome("cidade", ct.getCadastro().getEndereco().getCidade())).append(ct.getCadastro().getEndereco()).append("\n");
			conteudo.append(TextoUtil.formatarNome("uf", ct.getCadastro().getEndereco().getUF()));
			conteudo.append(FormatUtil.formatarCelular(ct.getCadastro().getCelular())).append("\n");
			conteudo.append(ct.getServico().getSiglaServico()).append("\n");
			
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
