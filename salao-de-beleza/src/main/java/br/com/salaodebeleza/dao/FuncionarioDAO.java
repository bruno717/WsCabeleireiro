package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.dto.FuncionarioDTO;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class FuncionarioDAO {

	// Criar funcionário
	public Boolean criarFuncionario(FuncionarioDTO funcionario) {

		Boolean resp = false;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_FUNCIONARIO_TB_USUARIOS_PROC;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, TipoUsuario.FUNCIONARIO);
			ps.setString(2, funcionario.getNome());
			ps.setInt(3, funcionario.getTelefone());
			ps.setString(4, funcionario.getEmail());
			ps.setString(5, funcionario.getSenha());
			ps.setInt(6, StatusUsuario.USUARIO_ATIVO);
			ps.setInt(7, TipoUsuario.ADM);
			ps.setInt(8, funcionario.getTelefone2());
			ps.setDate(9, new Date(funcionario.getDtNascimento().getTime()));
			ps.setLong(10, funcionario.getCpf());
			ps.setString(11, funcionario.getSexo());
			ps.setLong(12, 0L);
			ps.setInt(13, 0);
			ps.setInt(14, 0);
			ps.setInt(15, 0);
			ps.setInt(16, funcionario.getCep());
			ps.setString(17, funcionario.getLogradouro());
			ps.setString(18, funcionario.getNumero());
			ps.setString(19, funcionario.getBairro());
			ps.setString(20, funcionario.getCidade());
			ps.setString(21, funcionario.getEstado());
			ps.setString(22, funcionario.getPais());

			ps.execute();

			sql = MyQuery.SELECT_RESPONSE_STATUS;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				resp = rs.getString("resp").equals(
						StatusUsuario.USUARIO_CADASTRADO.toString());
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			resp = false;
		}

		return resp;
	}

	public FuncionarioDTO alterarFuncionario(FuncionarioDTO funcionario) {

		String sql;
		FuncionarioDTO dto = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_FUNCIONARIO;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, funcionario.getNome());
			ps.setInt(2, funcionario.getTelefone());
			ps.setString(3, funcionario.getEmail());
			ps.setString(4, funcionario.getSenha());
			ps.setInt(5, funcionario.getTelefone2());
			ps.setDate(6, new Date(funcionario.getDtNascimento().getTime()));
			ps.setLong(7, funcionario.getCpf());
			ps.setString(8, funcionario.getSexo());
			ps.setInt(9, funcionario.getCep());
			ps.setString(10, funcionario.getLogradouro());
			ps.setString(11, funcionario.getNumero());
			ps.setString(12, funcionario.getBairro());
			ps.setString(13, funcionario.getCidade());
			ps.setString(14, funcionario.getEstado());
			ps.setString(15, funcionario.getPais());
			ps.setInt(16, funcionario.getId());
			ps.execute();

			ps.close();
			con.close();

			dto = getFuncionario(funcionario.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	public FuncionarioDTO getFuncionario(String email) {

		String sql;
		FuncionarioDTO dto = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_USUARIO_TODOS_DADOS;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto = new FuncionarioDTO();
				dto.setId(rs.getInt("id_usuario"));
				dto.setTipoUsuario(rs.getInt("id_tipo_usuario"));
				dto.setNome(rs.getString("ds_nome"));
				dto.setTelefone(rs.getInt("nr_telefone"));
				dto.setEmail(rs.getString("ds_email"));
				dto.setSenha(rs.getString("cd_senha"));
				dto.setTelefone2(rs.getInt("nr_telefone2"));
				dto.setDtNascimento(rs.getDate("dt_nascimento"));
				dto.setCpf(rs.getLong("nr_cpf"));
				dto.setSexo(rs.getString("ds_sexo"));
				dto.setCep(rs.getInt("nr_cep"));
				dto.setLogradouro(rs.getString("ds_logradouro"));
				dto.setNumero(rs.getString("nr_numero"));
				dto.setBairro(rs.getString("ds_bairro"));
				dto.setCidade(rs.getString("ds_cidade"));
				dto.setEstado(rs.getString("ds_estado"));
				dto.setPais(rs.getString("ds_pais"));
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<FuncionarioDTO> getListaFuncionarios() {

		String sql;
		List<FuncionarioDTO> dtos = new ArrayList<FuncionarioDTO>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_USUARIOS;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, TipoUsuario.FUNCIONARIO);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				FuncionarioDTO dto = new FuncionarioDTO();

				dto.setId(rs.getInt("id_usuario"));
				dto.setTipoUsuario(rs.getInt("id_tipo_usuario"));
				dto.setNome(rs.getString("ds_nome"));
				dto.setTelefone(rs.getInt("nr_telefone"));
				dto.setEmail(rs.getString("ds_email"));
				dto.setSenha(rs.getString("cd_senha"));
				dto.setTelefone2(rs.getInt("nr_telefone2"));
				dto.setDtNascimento(rs.getDate("dt_nascimento"));
				dto.setCpf(rs.getLong("nr_cpf"));
				dto.setSexo(rs.getString("ds_sexo"));
				dto.setCep(rs.getInt("nr_cep"));
				dto.setLogradouro(rs.getString("ds_logradouro"));
				dto.setNumero(rs.getString("nr_numero"));
				dto.setBairro(rs.getString("ds_bairro"));
				dto.setCidade(rs.getString("ds_cidade"));
				dto.setEstado(rs.getString("ds_estado"));
				dto.setPais(rs.getString("ds_pais"));

				dtos.add(dto);

			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;

	}

}
