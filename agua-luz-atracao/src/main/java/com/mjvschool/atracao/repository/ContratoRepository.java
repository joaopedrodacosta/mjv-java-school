package main.java.com.mjvschool.atracao.repository;

import java.util.ArrayList;
import java.util.List;



public class ContratoRepository {
	private List <Contrato> contratos = new ArrayList<Contrato>();
	public void gravar(Contrato contato) {
		contratos.add(contato);
	}
	public List <Contrato> listarTodos(){
		return contratos;
	}
}
