package mjv.al.atracao.repository;

import java.util.ArrayList;
import java.util.List;

import mjv.al.atracao.model.Contrato;

public class ContratoRepository {
	private List <Contrato> contratos = new ArrayList<Contrato>();
	public void gravar(Contrato contato) {
		contratos.add(contato);
	}
	public List <Contrato> listarTodos(){
		return contratos;
	}
}
