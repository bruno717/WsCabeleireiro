package br.com.salaodebeleza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.salaodebeleza.dto.UsuarioDTO;
import br.com.salaodebeleza.util.MyQuery;
import br.com.salaodebeleza.util.StatusUsuario;

public class ClienteDAO {
	
	// Criar cliente
		public UsuarioDTO criarCliente(UsuarioDTO usuario){
			
			UsuarioDTO dto = null;
			String sql;
	        try {
	            Connection con = Connect.getConexao();
	            sql = MyQuery.INSERT_FUNCIONARIO_TB_USUARIOS_PROC;
	            PreparedStatement ps = (PreparedStatement) con.prepareStatement("call proc_insert_client (?, ?, ?, ?, ?, ?, @response_status)");

	            ps.setInt(1, StatusUsuario.CLIENTE);
	            ps.setString(2,  usuario.getNome());
	            ps.setInt(3, usuario.getTelefone());
	            ps.setString(4, usuario.getEmail());
	            ps.setString(5, usuario.getSenha());
	            ps.setInt(6, StatusUsuario.USUARIO_ATIVO);	  
	            
	            ps.execute();
	            
	            sql = MyQuery.SELECT_RESPONSE_STATUS;
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            if(rs.next()){
	            	if(rs.getString("resp").equals("5")){
	            		dto = new LoginDAO().loginWeb(usuario.getEmail(), usuario.getSenha());
	            	}
	            }
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			
			return dto;
		}
	
	 /*CallableStatement cs = con.prepareCall("call proc_insert_client (3, 'lucas', 123456789, 'teste@teste', '*luc1', 1)");*/

}
