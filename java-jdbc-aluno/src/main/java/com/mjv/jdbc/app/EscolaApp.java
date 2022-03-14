package com.mjv.jdbc.app;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.repository.AlunoRepository;
import com.mjv.jdbc.util.FabricaConexao;

public class EscolaApp {
	public static void main(String[] args) {
		try {

			Aluno aloisio = new Aluno();
/*
			aloisio.setAltura(1.83);
			aloisio.setAtivo(true);
			aloisio.setNome("Aloisio");
			aloisio.setSexo("M");


*/
			Aluno marcos = new Aluno();

/*
			marcos.setAltura(1.90);
			marcos.setAtivo(true);
			marcos.setNome("Marcos");
			marcos.setSexo("M");


 */
			Aluno joao = new Aluno();
			/*
			joao.setAltura(1.73);
			joao.setAtivo(false);
			joao.setNome("Joao");
			joao.setSexo("M");


			 */
			Aluno maria = new Aluno();
			/*
			maria.setAltura(1.75);
			maria.setAtivo(true);
			maria.setNome("Maria");
			maria.setSexo("F");
*/
			Aluno carlos = new Aluno();
			/*
			carlos.setAltura(1.65);
			carlos.setAtivo(false);
			carlos.setNome("Carlos");
			carlos.setSexo("M");
*/

			AlunoRepository alunoRepository = new AlunoRepository();
/*
			alunoRepository.gravar(aloisio);
			alunoRepository.gravar(marcos);
			alunoRepository.gravar(joao);
			alunoRepository.gravar(maria);
			alunoRepository.gravar(carlos);
			alunoRepository.alterarAluno(aloisio);
	*/
			//alunoRepository.listarAlunos();
			//alunoRepository.deletar(aloisio);
			//Aluno busca = alunoRepository.buscarAluno(22);
			//System.out.println(busca.getNome());
			FabricaConexao.fecharConexao();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
