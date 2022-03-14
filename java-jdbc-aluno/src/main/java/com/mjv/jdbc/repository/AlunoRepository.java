package com.mjv.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.util.FabricaConexao;

public class AlunoRepository {
	//padrao CRUD
	//Results
	
	public void gravar(Aluno aluno) {
		try {
			FabricaConexao.abrirConexao();
			Connection connection = FabricaConexao.getConexao();

			StringBuilder sql = new StringBuilder();

			sql.append("insert into tab_aluno (nome, altura ,sexo, ativo, cd_cidade)");
			sql.append(" values (?,?,?,?,?)");

			PreparedStatement procedimentoSql = connection.prepareStatement(sql.toString());

			procedimentoSql.setString(1, aluno.getNome());

			if(aluno.getAltura()==null)
				procedimentoSql.setNull(2, java.sql.Types.NULL);
			else
				procedimentoSql.setDouble(2, aluno.getAltura());
			
			procedimentoSql.setString(3, aluno.getSexo());
			procedimentoSql.setBoolean(4, aluno.isAtivo());
			procedimentoSql.setInt(5, 2211001);//jamais deve ser um valor fixo

			procedimentoSql.execute();

			System.out.println("registro inserido com sucesso");
			procedimentoSql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void listarAlunos(){

		try{
			FabricaConexao.abrirConexao();
		Connection connection = FabricaConexao.getConexao();

		String sql = "SELECT * FROM tab_aluno ";

		PreparedStatement procedimentoSql = connection.prepareStatement(sql);
			ResultSet result = procedimentoSql.executeQuery(sql);
			while(result.next()){
				int idAluno = result.getInt("id");
				String nome = result.getString("nome");
				double altura = result.getDouble("altura");
				String sexo = result.getString("sexo");
				boolean ativo = result.getBoolean("ativo");
				System.out.println(idAluno + ";" + nome + ", " + altura + ", " + sexo + ", " + ativo);

			}

		System.out.println("Select realizado com sucesso");
		procedimentoSql.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

    public Aluno buscarAluno(int id){

        Aluno aluno = null;
        try{
			FabricaConexao.abrirConexao();
            Connection connection = FabricaConexao.getConexao();

			StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM tab_aluno ");
			sql.append("WHERE id = ?");

            PreparedStatement procedimentoSql = connection.prepareStatement(sql.toString());
            procedimentoSql.setInt(1, id);
            ResultSet result = procedimentoSql.executeQuery();

            if(result.next()){
                aluno = new Aluno();
                aluno.setIdAluno(result.getInt("id"));
                aluno.setNome(result.getString("nome"));
                aluno.setAltura(result.getDouble("altura"));
                aluno.setSexo(result.getString("sexo"));
                aluno.setAtivo(result.getBoolean("ativo"));

            }

            System.out.println("Busca por aluno realizado com sucesso");
            procedimentoSql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluno;

    }

	public boolean deletar(Aluno aluno){
			boolean exlusao = false;
		try{
			FabricaConexao.abrirConexao();
			Connection connection = FabricaConexao.getConexao();

			String sql = ("SELECT * FROM tab_aluno");
			String sql2 = ("DELETE from tab_aluno where id = ?");

			PreparedStatement procedimentoSql = connection.prepareStatement(sql);
			PreparedStatement procedimentoSql2 = connection.prepareStatement(sql2);
			ResultSet result  = procedimentoSql.executeQuery(sql);
			if(result.next())
				aluno.setIdAluno(result.getInt("id"));

			procedimentoSql2.setInt(1, aluno.getIdAluno());

			procedimentoSql2.execute();
			System.out.println("Exclusão realizada com sucesso");

			procedimentoSql.close();
			procedimentoSql2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exlusao;

	}


	public void alterarAluno(Aluno aluno){

		try{
			FabricaConexao.abrirConexao();
			Connection connection = FabricaConexao.getConexao();

			String sql = ("SELECT * FROM tab_aluno");
			String sql2 = ("update tab_aluno set nome = ?, altura = ?, sexo = ?, ativo = ? where id = ?");


			PreparedStatement procedimentoSql = connection.prepareStatement(sql);
			PreparedStatement procedimentoSql2 = connection.prepareStatement(sql2);
			ResultSet result  = procedimentoSql.executeQuery(sql);
			if(result.next())
			aluno.setIdAluno(result.getInt("id"));

			procedimentoSql2.setString(1, aluno.getNome());
			if(aluno.getAltura()==null)
				procedimentoSql2.setNull(2, java.sql.Types.NULL);
			else
				procedimentoSql2.setDouble(2, aluno.getAltura());

			procedimentoSql2.setString(3, aluno.getSexo());
			procedimentoSql2.setBoolean(4, aluno.isAtivo());
			procedimentoSql2.setInt(5, aluno.getIdAluno());


			procedimentoSql2.execute();

			System.out.println("Alteração realizada com sucesso");
			procedimentoSql.close();
			procedimentoSql2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

