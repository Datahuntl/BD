DROP DATABASE IF EXISTS teste;
CREATE DATABASE teste;
USE teste;
# QUESTÃO 1
CREATE TABLE IF NOT EXISTS q1(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    endereco VARCHAR(45),
    cargo VARCHAR(45)
    );

# FAÇA 3 INSERÇÕES NA TABELA
INSERT INTO q1 (nome, endereco, cargo) VALUES ("Klebesvaldo","Rua 1","Engenheiro Químico");
INSERT INTO q1 (nome, endereco, cargo) VALUES ("Hunberto","Rua 2","Tecnico de Manutenção");
INSERT INTO q1 (nome, endereco, cargo) VALUES ("Franklin","Rua 3","Zelador");

#SELECT * FROM q1;

# FAÇA UMA CONSULTA QUE MOSTRE SOMENTE O NOME DE TODOS OS REGISTROS
SELECT nome FROM q1;

# ATUALIZE O ENDEREÇO DO PRIMEIRO REGISTRO
UPDATE q1 SET endereco = 'Rua 10' WHERE ID = '1';

#SELECT * FROM q1;

DELETE FROM q1 WHERE ID = '3';

SELECT * FROM q1;
