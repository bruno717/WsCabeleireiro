package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.salaodebeleza.model.FuncionarioModel;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;

public class FuncionarioDAO {

	// Criar funcionário
	public Boolean criarFuncionario(FuncionarioModel funcionario){
		
		Boolean resp = false;
		String sql;
        try {
            Connection con = Connect.getConexao();
            sql = MyQuery.INSERT_FUNCIONARIO_TB_USUARIOS_PROC;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, StatusUsuario.FUNCIONARIO);
            ps.setString(2,  funcionario.getPessoaFisica().getPessoa().getNome());
            ps.setInt(3, funcionario.getPessoaFisica().getPessoa().getTelefone());
            ps.setString(4, funcionario.getPessoaFisica().getPessoa().getEmail());
            ps.setString(5, funcionario.getPessoaFisica().getPessoa().getSenha());
            ps.setInt(6, StatusUsuario.USUARIO_ATIVO);
            ps.setInt(7, StatusUsuario.ADM);
            ps.setInt(8, funcionario.getPessoaFisica().getPessoa().getTelefone2());
            ps.setDate(9, new Date(funcionario.getPessoaFisica().getPessoa().getDtNascimento().getTime()));
            ps.setLong(10, funcionario.getPessoaFisica().getCpf());
            ps.setString(11, funcionario.getPessoaFisica().getPessoa().getSexo());
            ps.setLong(12, 0L);
            ps.setInt(13, 0);
            ps.setInt(14, 0);
            ps.setInt(15, 0);
            ps.setInt(16, funcionario.getPessoaFisica().getPessoa().getCep());
            ps.setString(17,funcionario.getPessoaFisica().getPessoa().getLogradouro());
            ps.setString(18,funcionario.getPessoaFisica().getPessoa().getNumero());
            ps.setString(19, funcionario.getPessoaFisica().getPessoa().getBairro());
            ps.setString(20, funcionario.getPessoaFisica().getPessoa().getCidade());
            ps.setString(21, funcionario.getPessoaFisica().getPessoa().getEstado());
            ps.setString(22, funcionario.getPessoaFisica().getPessoa().getPais());
            
            ps.execute();
            
            sql = MyQuery.SELECT_RESPONSE_STATUS;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
            	resp = rs.getString("resp").equals("5");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
        	e.printStackTrace();
            resp = false;
        }
		
		return resp;
	}
}
