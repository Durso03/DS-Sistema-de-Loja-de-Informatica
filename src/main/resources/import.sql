INSERT INTO tb_pessoa (nome, cpf, endereco, telefone, email) VALUES ('Pedro Henrique', '12345678901', 'Rua Linux, Centro, Ipatinga', '11999999999', 'pedro@email.com');
INSERT INTO tb_pessoa (nome, cpf, endereco, telefone, email) VALUES ('Odilon Correa', '98765432100', 'Rua Cefet, Centro, Timóteo', '11888888888', 'odilon@email.com');
INSERT INTO tb_pessoa (nome, cpf, endereco, telefone, email) VALUES ('Bruno Durso', '12345678922', 'Rua Tal, Bromelias, Timoteo', '11888888889', 'bruno@email.com');
INSERT INTO tb_pessoa (nome, cpf, endereco, telefone, email) VALUES ('Jose da Silva', '12345678300', 'Rua X, Centro, Fabriciano', '11888888300', 'jose@email.com');

INSERT INTO tb_usuario (login, senha, tipo, id_pessoa) VALUES ('pedrohenrique', '123456', 'VENDEDOR', 1);
INSERT INTO tb_usuario (login, senha, tipo, id_pessoa) VALUES ('odiloncorrea', 'abcdef', 'CLIENTE', 2);
INSERT INTO tb_usuario (login, senha, tipo, id_pessoa) VALUES ('brunodurso', 'defabc', 'VENDEDOR', 3);
INSERT INTO tb_usuario (login, senha, tipo, id_pessoa) VALUES ('josedasilva', 'whatsapp', 'CLIENTE', 4);

INSERT INTO tb_categoria (descricao) VALUES ('Teclados');
INSERT INTO tb_categoria (descricao) VALUES ('Mouses');
INSERT INTO tb_categoria (descricao) VALUES ('Monitores');

INSERT INTO tb_produto (descricao, valor, estoque, id_categoria) VALUES ('Teclado Mecânico RedDragon RGB', 350.00, 10, 1);
INSERT INTO tb_produto (descricao, valor, estoque, id_categoria) VALUES ('Mouse Sem Fio Logitech 9000DPI', 240.00, 50, 2);
INSERT INTO tb_produto (descricao, valor, estoque, id_categoria) VALUES ('Monitor Gamer Samsung 24pol 120hz', 1050.00, 5, 3);
INSERT INTO tb_produto (descricao, valor, estoque, id_categoria) VALUES ('Monitor Gamer AOC 21pol 75hz', 630.00, 20, 3);

INSERT INTO tb_venda (data, valor, observacao, id_pessoa_cliente, id_pessoa_funcionario) VALUES ('2025-06-21', 2470.00, 'Venda no balcão sem desconto', 2, 1);

INSERT INTO tb_venda_produto (id_venda, id_produto, quantidade) VALUES (1, 1, 5); --pedro vendeu 5 qtds de teclado
INSERT INTO tb_venda_produto (id_venda, id_produto, quantidade) VALUES (1, 2, 3); --e 3 qtds de mouse para o odilon
