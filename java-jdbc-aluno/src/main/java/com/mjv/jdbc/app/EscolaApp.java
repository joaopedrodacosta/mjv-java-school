package com.mjv.jdbc.app;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.repository.AlunoRepository;
import com.mjv.jdbc.util.FabricaConexao;

public class EscolaApp {
	public static void main(String[] args) {
		try {
			Aluno aloisio = new Aluno();
			aloisio.setAltura(1.83);
			aloisio.setAtivo(true);
			aloisio.setNome("Aloisio");
			aloisio.setSexo("M");
			
			
			AlunoRepository alunoRepository = new AlunoRepository();
			alunoRepository.gravar(aloisio);
			FabricaConexao.fecharConexao();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
