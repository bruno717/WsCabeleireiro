package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salaodebeleza.dto.ClienteDTO;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;
import br.com.salaodebeleza.util.TipoUsuario;

public class ClienteDAO {

	// Criar cliente
	public ClienteDTO criarCliente(ClienteDTO cliente) {

		ClienteDTO dto = null;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.INSERT_CLIENTE_TB_USUARIOS_PROC;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, TipoUsuario.CLIENTE);
			ps.setString(2, cliente.getNome());
			ps.setInt(3, cliente.getTelefone());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getSenha());
			ps.setInt(6, StatusUsuario.USUARIO_ATIVO);

			ps.execute();

			sql = MyQuery.SELECT_RESPONSE_STATUS;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				if (rs.getString("resp").equals(
						StatusUsuario.USUARIO_CADASTRADO.toString())) {
					dto = new ClienteDAO().getClienteSimplesPorEmail(cliente
							.getEmail());
				}
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ClienteDTO alterarCliente(ClienteDTO dto) {

		ClienteDTO cliente = null;
		String sql;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.UPDATE_CLIENTE;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getId());
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, TipoUsuario.CLIENTE);
			ps.setString(5, dto.getNome());
			ps.setInt(6, dto.getTelefone());
			ps.setString(7, dto.getEmail());
			ps.setString(8, dto.getSenha());
			ps.setInt(9, StatusUsuario.USUARIO_ATIVO);
			ps.setInt(10, TipoUsuario.ADM);
			ps.setInt(11, dto.getTelefone2());
			ps.setDate(12, new Date(dto.getDtNascimento().getTime()));
			ps.setLong(13, dto.getCpf());
			ps.setString(14, dto.getSexo());
			ps.setLong(15, 0L);
			ps.setInt(16, 0);
			ps.setInt(17, 0);
			ps.setInt(18, 0);
			ps.setInt(19, dto.getCep());
			ps.setString(20, dto.getLogradouro());
			ps.setString(21, dto.getNumero());
			ps.setString(22, dto.getBairro());
			ps.setString(23, dto.getCidade());
			ps.setString(24, dto.getEstado());
			ps.setString(25, dto.getPais());

			ps.execute();
			ps.close();
			con.close();

			cliente = getCliente(dto.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public ClienteDTO getCliente(String email) {

		String sql;
		ClienteDTO dto = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_USUARIO_TODOS_DADOS;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto = new ClienteDTO();
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
			} else {
				dto = new ClienteDTO();
				dto = getClienteSimplesPorEmail(email);
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<ClienteDTO> buscarClientes() {
		String sql;
		List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_USUARIOS;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, TipoUsuario.CLIENTE);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ClienteDTO dto = new ClienteDTO();

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

	private ClienteDTO getClienteSimplesPorEmail(String email) {

		String sql;
		ClienteDTO dto = null;
		try {
			Connection con = Connect.getConexao();
			sql = MyQuery.SELECT_CLIENTE_SIMPLES;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto = new ClienteDTO();
				dto.setId(rs.getInt("id_usuario"));
				dto.setTipoUsuario(rs.getInt("id_tipo_usuario"));
				dto.setNome(rs.getString("ds_nome"));
				dto.setTelefone(rs.getInt("nr_telefone"));
				dto.setEmail(rs.getString("ds_email"));
				dto.setSenha(rs.getString("cd_senha"));
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
