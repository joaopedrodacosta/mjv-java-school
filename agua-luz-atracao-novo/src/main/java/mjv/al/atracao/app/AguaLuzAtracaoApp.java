package mjv.al.atracao.app;

import java.time.LocalDateTime;
import java.util.List;

import mjv.al.atracao.model.Contrato;
import mjv.al.atracao.model.Endereco;
import mjv.al.atracao.model.NotificacaoTipo;
import mjv.al.atracao.model.Pais;
import mjv.al.atracao.model.Pessoa;
import mjv.al.atracao.model.Servico;
import mjv.al.atracao.repository.ContratoRepository;
import mjv.al.atracao.service.GeradorArquivo;




public class AguaLuzAtracaoApp {
	private static ContratoRepository contratoRepositorio = new ContratoRepository();
	public static void main(String[] args) {
		faseAtrairCadastroContratos();
		faseGeracaoArquivos();
	}
	
	private static void faseAtrairCadastroContratos() {
		System.out.println("\n*** INICIANDO A FASE DE ATRA��ODE CONTRATOS ***");
		Contrato contrato = new Contrato();
        contrato.setNumeroProtocolo(2022025687L);
        contrato.setServico(Servico.LUZ);
        contrato.setNotificacaoTipo(NotificacaoTipo.SMS);

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("238.402.650-02");
        pessoa.setNome("Gleyson Sampaio de Oliveira");
        pessoa.setRg("6517SSPSP");
        pessoa.setCelular("98965498760");
        pessoa.setPais(Pais.BR);

        Endereco endereco = new Endereco();
        endereco.setBairro("Santo Antonio");
        endereco.setCep("08220970");
        endereco.setCidade("S�o Paulo");
        endereco.setEstado("SP");
        endereco.setLogradouro("Rua das Marias");
        endereco.setNumero("243");
        endereco.setComplemento("Pr�ximo ao quebra molas");
        pessoa.setEndereco(endereco);
        
        contrato.setPessoa(pessoa);
        contrato.setDataHora(LocalDateTime.now().minusDays(5));
        System.out.println(contrato);
        contratoRepositorio.gravar(contrato);

        Contrato contrato2 = new Contrato();
        contrato2.setNumeroProtocolo(2022025333L);
        contrato2.setServico(Servico.AGUA);
        contrato2.setNotificacaoTipo(NotificacaoTipo.WHATS);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setCpf("470.220.160-38");
        pessoa2.setNome("Raimundo Nonato Loureiro Castelo Branco");
        pessoa2.setRg("8671-9");
        pessoa2.setCelular("21987126534");
        pessoa2.setPais(Pais.US);

        Endereco endereco2 = new Endereco();
        endereco2.setBairro("Santo Antonio");
        endereco2.setCep("58076037");
        endereco2.setCidade("Rio de Janeiro");
        endereco2.setEstado("RJ");
        endereco2.setLogradouro("Rua Duque de Caxias");
        endereco2.setNumero("243");
        endereco2.setComplemento("Perto do Bobs");
        pessoa2.setEndereco(endereco2);
        contrato2.setPessoa(pessoa2);
        contrato2.setDataHora(LocalDateTime.now().plusHours(4).plusMinutes(17));
        System.out.println(contrato2);
        contratoRepositorio.gravar(contrato2);
        System.out.println("*** FINALIZANDO A FASE DE ATRA��O DE CONTRATOS ***");
		
	}
	
	private static void faseGeracaoArquivos() {
		System.out.println("\n*** INICIANDO A FASE DE GERA��O DE ARQUIVOS ***\n");
		
		List<Contrato> contratos = contratoRepositorio.listarTodos();
		
		GeradorArquivo gerador = new GeradorArquivo();
		gerador.gerarArquivoTxt(contratos);
		System.out.println("\n*** FINALIZANDO A FASE DE GERA��O DE CONTEUDOS***");
		
	}
}
