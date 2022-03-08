package mjv.al.atracao.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mjv.al.atracao.model.Contrato;
import mjv.al.atracao.model.Endereco;
import mjv.al.atracao.model.NotificacaoTipo;
import mjv.al.atracao.model.Pais;
import mjv.al.atracao.model.Pessoa;
import mjv.al.atracao.model.Servico;

public class LeitorContrato {
	public List<Contrato> lerArquivo(){
		List<Contrato> contratos = new ArrayList<Contrato>();
		
		try {
			
			List<String> linhas = obterLinhas();
			
			for(String linha: linhas) {
				Contrato contrato = new Contrato();
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(linha.substring(0,11));//11-0 = 11
				pessoa.setRg(linha.substring(11, 21).trim());//21-11=10
				pessoa.setNome(linha.substring(21, 51).trim());
				pessoa.setCelular(linha.substring(51, 62));
				
				Endereco endereco = new Endereco();
				endereco.setLogradouro(linha.substring(62,82).trim());
				endereco.setNumero(linha.substring(82,88).trim());
				endereco.setComplemento(linha.substring(88,98).trim());
				endereco.setBairro(linha.substring(98,113).trim());
				endereco.setCidade(linha.substring(113,143).trim());
				endereco.setEstado(linha.substring(143,145).trim());
				endereco.setCep(linha.substring(145,153).trim());
				pessoa.setPais(Pais.valueOf(linha.substring(153,155)));
				pessoa.setEndereco(endereco);
				
				contrato.setPessoa(pessoa);
				contrato.setNumeroProtocolo(Long.valueOf(linha.substring(155,165)));
				contrato.setDataHora(LocalDateTime.parse(linha.substring(165,177), DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
				String sigla = linha.substring(177,178);
				contrato.setServico(Servico.buscarPorSigla(sigla));
				Double valor = Double.valueOf(linha.substring(178,186)) / 100;
				System.out.println(valor);
				sigla = linha.substring(186,187);
				contrato.setNotificacaoTipo(NotificacaoTipo.buscarPorSigla(sigla));
				contratos.add(contrato);
				System.out.println("Convertendo contrato...");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return contratos;
		
	}
	private List<String> obterLinhas() throws Exception {
        List<String> linhas;
        try (Stream<String> lines = Files.lines(Paths.get("/estudo/mjv-java-school/agua-luz-output/agua-luz-contratos.txt"))) {
            linhas = lines.collect(Collectors.toList());
        }
        return linhas;
    }
}

