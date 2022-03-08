package mjv.al.atracao.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import mjv.al.atracao.model.Contrato;
import mjv.al.atracao.model.Endereco;
import mjv.al.atracao.model.Pessoa;
import mjv.al.atracao.util.TextoUtil;

public class GeradorArquivo {
	public void gerarArquivoCsv(List<Contrato> contratos) {
		StringBuilder conteudo = new StringBuilder();

		for (Contrato contrato : contratos) {
			conteudo.append(contrato.getNumeroProtocolo()+";");
			//conteudo.append(FormatUtil.formatarDataHora(contrato.getDataHora()).concat(";"));
			conteudo.append(contrato.getNotificacaoTipo().getSigla().concat(";"));
			conteudo.append(contrato.getServico().getSigla() + ";");
			
			Pessoa pessoa = contrato.getPessoa();
			conteudo.append(pessoa.getCpf().concat(";"));
			conteudo.append(pessoa.getNome().concat(";"));
			conteudo.append(pessoa.getRg().concat(";"));
			conteudo.append(pessoa.getCelular().concat(";"));
			
			Endereco endereco = pessoa.getEndereco();
			conteudo.append(endereco.getLogradouro().concat(";"));
			conteudo.append(endereco.getNumero().concat(";"));
			conteudo.append(endereco.getComplemento().concat(";"));
			conteudo.append(endereco.getBairro().concat(";"));
			conteudo.append(endereco.getCep().concat(";"));
			conteudo.append(endereco.getCidade().concat(";"));
			conteudo.append(endereco.getEstado().concat(";"));
			conteudo.append("\n");
		}
		escreverEmDisco(conteudo.toString().toUpperCase(), "agua-luz-contratos.csv");
		System.out.println(conteudo.toString());
		
	}
	public void gerarArquivoTxt(List<Contrato> contratos) {
		StringBuilder conteudo = new StringBuilder();

		for (Contrato contrato : contratos) {
			Pessoa pessoa = contrato.getPessoa();
			conteudo.append(pessoa.getCpf().replaceAll("\\D", "") );
			conteudo.append(TextoUtil.ajustar(pessoa.getRg(), 10));
			conteudo.append(TextoUtil.ajustar(pessoa.getNome(), 30));
			conteudo.append(pessoa.getCelular().replaceAll("\\D", "") );
			
			Endereco endereco = pessoa.getEndereco();
			conteudo.append(TextoUtil.ajustar(endereco.getLogradouro(),20));
			conteudo.append(TextoUtil.completarZeros(Integer.valueOf(endereco.getNumero()), 6) );
			conteudo.append(TextoUtil.ajustar(endereco.getComplemento(),10));
			conteudo.append(TextoUtil.ajustar(endereco.getBairro(),15));
			conteudo.append(TextoUtil.ajustar(endereco.getCidade(),30));
			conteudo.append(endereco.getEstado());
			conteudo.append(endereco.getCep().replaceAll("\\D", ""));
			conteudo.append(pessoa.getPais().name());
			
			conteudo.append(TextoUtil.completarZeros(contrato.getNumeroProtocolo(),10));
			LocalDateTime dataHora = contrato.getDataHora();
			conteudo.append(dataHora.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			conteudo.append(dataHora.format(DateTimeFormatter.ofPattern("HHmm")));
			conteudo.append(contrato.getServico().getSigla());
			conteudo.append(TextoUtil.completarZeros(contrato.getServico().getValor(),8));
			conteudo.append(contrato.getNotificacaoTipo().getSigla());
			
			conteudo.append("\n");
		}
		System.out.println(conteudo.toString());
		
		escreverEmDisco(conteudo.toString().toUpperCase(), "agua-luz-contratos.txt");
	}
	public void gerarContrato(String conteudo,String cpf) {
		cpf = cpf.replaceAll("\\D", "");
		escreverEmDisco(conteudo, cpf.concat(".txt"));
	}
	private void escreverEmDisco(String conteudo, String nomeArquivo) {
		//C:\estudo\mjv-java-school\agua-luz-output;
		File dir = new File("/estudo/mjv-java-school/agua-luz-output");
		if(!dir.exists())
			dir.mkdirs();
		Path path = Paths.get(dir.getAbsolutePath().concat("/").concat(nomeArquivo));

		try {
			Files.write(path, conteudo.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
