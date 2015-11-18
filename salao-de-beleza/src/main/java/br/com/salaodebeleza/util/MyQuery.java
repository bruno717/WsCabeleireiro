package br.com.salaodebeleza.util;

public class MyQuery {

	public static final String SELECT_RESPONSE_STATUS = "SELECT @response_status AS resp";

	// Usuario
	public static final String SELECT_USUARIO_TODOS_DADOS = "SELECT * FROM tb_usuarios AS u INNER JOIN tb_dados_usuarios AS d INNER JOIN tb_enderecos AS e ON u.id_usuario = d.id_usuario AND d.id_endereco = e.id_endereco WHERE u.ds_email = ?";
	public static final String UPDATE_INATIVAR_USUARIO = "UPDATE tb_usuarios AS u SET u.cd_status=2 WHERE u.id_usuario = ?";
	// public static final String SELECT_USUARIOS =
	// "SELECT * FROM tb_usuarios AS u INNER JOIN tb_dados_usuarios AS d INNER JOIN tb_enderecos AS e ON u.id_usuario = d.id_usuario AND d.id_endereco = e.id_endereco WHERE u.id_tipo_usuario = ? ORDER BY u.ds_nome";
	public static final String SELECT_USUARIOS = "SELECT * FROM tb_usuarios AS u LEFT JOIN tb_dados_usuarios AS d ON u.id_usuario = d.id_usuario LEFT JOIN tb_enderecos AS e ON d.id_endereco = e.id_endereco WHERE u.id_tipo_usuario = ? ORDER BY u.ds_nome";
	public static final String SELECT_USUARIOS_SIMPLES = "SELECT * FROM tb_usuarios WHERE id_tipo_usuario = ? ORDER BY ds_nome";

	// Funcionario
	public static final String INSERT_FUNCIONARIO_TB_USUARIOS_PROC = "CALL proc_insert_employee (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String UPDATE_FUNCIONARIO = "UPDATE tb_usuarios AS u, tb_dados_usuarios AS d, tb_enderecos AS e SET u.ds_nome=?, u.nr_telefone=?, u.ds_email=?, u.cd_senha=?, d.nr_telefone2=?, d.dt_nascimento=?, d.nr_cpf=?, d.ds_sexo=?, e.nr_cep=?, e.ds_logradouro=?, e.nr_numero=?, e.ds_bairro=?, e.ds_cidade=?, e.ds_estado=?, e.ds_pais=? WHERE u.id_usuario = ?";

	// Cliente
	public static final String INSERT_CLIENTE_TB_USUARIOS_PROC = "CALL proc_insert_client (?, ?, ?, ?, ?, ?, @response_status)";
	public static final String UPDATE_CLIENTE = "CALL proc_update_client (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, @response_status)";
	public static final String SELECT_CLIENTE_SIMPLES = "SELECT * FROM tb_usuarios WHERE ds_email = ?";

	// TipoProduto
	public static final String INSERT_TIPO_PRODUTO = "INSERT INTO tb_tipos_produtos (ds_tipo_produto, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_TIPO_PRODUTO = "UPDATE tb_tipos_produtos SET ds_tipo_produto=? WHERE id_tipo_produto = ?";
	public static final String SELECT_TIPO_PRODUTO = "SELECT * FROM tb_tipos_produtos WHERE id_tipo_produto = ?";
	public static final String SELECT_TIPOS_PRODUTOS = "SELECT * FROM tb_tipos_produtos WHERE cd_status = 1 ORDER BY ds_tipo_produto";

	// Produto
	public static final String INSERT_PRODUTO = "INSERT INTO tb_produtos (id_tipo_produto, ds_produto, ds_fabricante, vl_preco, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_PRODUTO = "UPDATE tb_produtos SET id_tipo_produto=?, ds_produto=?, ds_fabricante=?, vl_preco=? WHERE id_produto = ?";
	public static final String SELECT_PRODUTO = "SELECT * FROM tb_produtos WHERE id_produto = ?";
	public static final String SELECT_PRODUTOS = "SELECT * FROM tb_produtos WHERE cd_status = 1 ORDER BY ds_produto";
	public static final String SELECT_PRODUTOS_MAIS_VENDIDO_LISTA = "SELECT * FROM tb_produtos_vendidos WHERE cd_status = ? AND id_produto = ?";
	public static final String SELECT_PRODUTO_MAIS_VENDIDO = "SELECT COUNT(*) AS qtd, id_produto FROM tb_produtos_vendidos GROUP BY id_produto ORDER BY qtd DESC";

	// Estoque
	public static final String INSERT_PRODUTO_ESTOQUE = "INSERT INTO tb_estoque (id_produto, qt_produto) VALUES (?, ?)";
	public static final String UPDATE_PRODUTO_ESTOQUE = "UPDATE tb_estoque SET qt_produto = ? WHERE id_estoque = ?";
	public static final String UPDATE_PRODUTO_ESTOQUE_ID_PRODUTO = "UPDATE tb_estoque SET qt_produto = ? WHERE id_produto = ?";
	public static final String DELETE_PRODUTO_ESTOQUE = "DELETE FROM tb_estoque WHERE id_estoque = ?";
	public static final String SELECT_PRODUTO_ESTOQUE = "SELECT * FROM tb_estoque WHERE id_estoque = ?";
	public static final String SELECT_PRODUTOS_ESTOQUE = "SELECT * FROM tb_estoque";

	// Compra
	public static final String INSERT_COMPRA = "INSERT INTO tb_compras (id_usuario, id_tipo_pagamento, id_usuario_cadastro, cd_status, dt_operacao) VALUES (?, ?, ?, ?, ?)";
	public static final String UPDATE_STATUS_COMPRA = "UPDATE tb_compras SET cd_status=? WHERE id_compra=?";

	public static final String INSERT_PRODUTOS_COMPRADOS = "INSERT INTO tb_produtos_comprados (id_compra, id_produto, id_servico, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_STATUS_PRODUTOS_COMPRADOS = "UPDATE tb_produtos_comprados SET cd_status=? WHERE id_compra=?";
	public static final String SELECT_QUANTIDADE_PRODUTOS_COMPRADOS = "SELECT * FROM tb_produtos_comprados WHERE id_compra=?";

	public static final String SELECT_COMPRAS = "SELECT * FROM tb_compras";

	// Pedido
	public static final String INSERT_PEDIDO = "INSERT INTO tb_pedidos (id_compra, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_STATUS_PEDIDO = "UPDATE tb_pedidos SET cd_status=? WHERE id_pedido=?";
	public static final String SELECT_PEDIDO = "SELECT * FROM tb_pedidos WHERE id_pedido=?";

	// Tipo Conta
	public static final String INSERT_TIPO_CONTA = "INSERT INTO tb_tipos_contas (ds_tipo_conta, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_TIPO_CONTA = "UPDATE tb_tipos_contas SET ds_tipo_conta=? WHERE id_tipo_conta=?";
	public static final String SELECT_TIPO_CONTAS = "SELECT * FROM tb_tipos_contas ORDER BY ds_tipo_conta";
	public static final String SELECT_TIPO_CONTA = "SELECT * FROM tb_tipos_contas WHERE id_tipo_conta=?";

	// Conta Pagar
	public static final String INSERT_CONTA_PAGAR = "INSERT INTO tb_contas_pagar (id_pedido, id_tipo_conta, nr_parcelas, nr_parcela_atual, dt_vencimento, dt_pagamento, qt_desconto, qt_juros, vl_total_conta, vl_total_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SELECT_CONTAS_PAGAR_POR_DATA_DIA = "SELECT * FROM tb_contas_pagar WHERE dt_pagamento = ?";
	public static final String SELECT_CONTAS_PAGAR_POR_DATA_PERIODO = "SELECT * FROM tb_contas_pagar WHERE dt_pagamento >= ? AND dt_pagamento <= ?";
	
	// Venda
	public static final String INSERT_VENDA = "INSERT INTO tb_vendas (id_usuario, id_tipo_recebimento, id_usuario_cadastro, cd_status, dt_operacao) VALUES (?, ?, ?, ?, ?)";
	public static final String SELECT_VENDAS = "SELECT * FROM tb_vendas";
	public static final String UPDATE_STATUS_VENDA = "UPDATE tb_vendas SET cd_status=? WHERE id_venda=?";
	public static final String SELECT_VENDA = "SELECT * FROM tb_vendas WHERE id_venda = ?";

	public static final String INSERT_PRODUTOS_VENDIDOS = "INSERT INTO tb_produtos_vendidos (id_venda, id_produto, id_servico, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_STATUS_PRODUTOS_VENDIDOS = "UPDATE tb_produtos_vendidos SET cd_status=? WHERE id_venda=?";

	// Conta Receber
	public static final String INSERT_CONTA_RECEBER = "INSERT INTO tb_contas_receber (id_venda, id_tipo_conta, nr_parcelas, nr_parcela_atual, dt_vencimento, dt_recebimento, qt_desconto, qt_juros, vl_total_conta, vl_total_recebido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SELECT_CONTAS_RECEBER_POR_DATA_DIA = "SELECT * FROM tb_contas_receber WHERE dt_recebimento = ?";
	public static final String SELECT_CONTAS_RECEBER_POR_DATA_PERIODO = "SELECT * FROM tb_contas_receber WHERE dt_recebimento >= ? AND dt_recebimento <= ?";

	// Tipo Horario
	public static final String INSERT_TIPO_HORARIO = "INSERT INTO tb_tipos_horarios (ds_tipo_horario, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_TIPO_HORARIO = "UPDATE tb_tipos_horarios SET ds_tipo_horario=? WHERE id_tipo_horario = ?";
	public static final String SELECT_TIPO_HORARIO = "SELECT * FROM tb_tipos_horarios WHERE id_tipo_horario = ?";
	public static final String SELECT_TIPOS_HORARIOS = "SELECT * FROM tb_tipos_horarios WHERE cd_status = 1 ORDER BY ds_tipo_horario";

	// Tipo Horario
	public static final String INSERT_HORARIO = "INSERT INTO tb_horarios (id_tipo_horario, ds_horario, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?)";
	public static final String UPDATE_HORARIO = "UPDATE tb_horarios SET id_tipo_horario=?, ds_horario=? WHERE id_horario = ?";
	public static final String SELECT_HORARIO = "SELECT * FROM tb_horarios WHERE id_horario = ?";
	public static final String SELECT_HORARIOS = "SELECT * FROM tb_horarios WHERE cd_status = 1 ORDER BY ds_horario";
	public static final String SELECT_HORARIOS_POR_TIPO_HORARIO = "SELECT * FROM tb_horarios WHERE cd_status = 1 AND id_tipo_horario = ? ORDER BY ds_horario";
	public static final String SELECT_HORARIOS_DISPONIVEIS = "call verifica_agenda(?, ?, ?, ?, @response_status)";

	// Tipo Servico
	public static final String INSERT_TIPO_SERVICO = "INSERT INTO tb_tipos_servicos (ds_tipo_servico, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_TIPO_SERVICO = "UPDATE tb_tipos_servicos SET ds_tipo_servico=? WHERE id_tipo_servico = ?";
	public static final String SELECT_TIPO_SERVICO = "SELECT * FROM tb_tipos_servicos WHERE id_tipo_servico = ?";
	public static final String SELECT_TIPOS_SERVICOS = "SELECT * FROM tb_tipos_servicos WHERE cd_status = 1 ORDER BY ds_tipo_servico";

	// Servico
	public static final String INSERT_SERVICO = "INSERT INTO tb_servicos (id_tipo_servico, ds_servico, vl_preco, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_SERVICO = "UPDATE tb_servicos SET id_tipo_servico=?, ds_servico=?, vl_preco=? WHERE id_servico = ?";
	public static final String SELECT_SERVICO = "SELECT * FROM tb_servicos WHERE id_servico = ?";
	public static final String SELECT_SERVICOS = "SELECT * FROM tb_servicos WHERE cd_status = 1 ORDER BY ds_servico";
	public static final String SELECT_SERVICOS_POR_TIPO_SERVICO = "SELECT * FROM tb_servicos WHERE cd_status = 1 AND id_tipo_servico= ? ORDER BY ds_servico";

	// Atividade (Servico Funcionario)
	public static final String INSERT_ATIVIDADE = "INSERT INTO tb_atividades (id_usuario, id_servico, id_horario, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_ATIVIDADE = "UPDATE tb_atividades SET id_usuario=?, id_servico=?, id_horario=? WHERE id_atividade = ?";
	public static final String SELECT_ATIVIDADE = "SELECT * FROM tb_atividades WHERE id_atividade = ?";
	public static final String SELECT_ATIVIDADES = "SELECT * FROM tb_atividades WHERE cd_status = 1";
	// public static final String SELECT_SERVICOS_POR_TIPO_SERVICO =
	// "SELECT * FROM tb_servicos WHERE cd_status = 1 AND id_tipo_servico= ? ORDER BY ds_servico";

	// Atividade (Servico Funcionario)
	public static final String INSERT_AGENDA = "INSERT INTO tb_agenda (id_horario, id_usuario, id_atividade, dt_reserva, cd_status, dt_operacao, id_usuario_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_AGENDA = "UPDATE tb_agenda SET id_horario=?, id_usuario=?, id_atividade=?, dt_reserva=? WHERE id_agenda = ?";
	public static final String SELECT_AGENDA = "SELECT * FROM tb_agenda WHERE id_agenda = ?";
	public static final String SELECT_AGENDAS = "SELECT * FROM tb_agenda WHERE cd_status = 1";

}