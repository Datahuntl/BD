CREATE DATABASE TABELA;

SET SQL_SAFE_UPDATES = 0;

DROP DATABASE IF EXISTS TABELA;

CREATE DATABASE TABELA;

USE TABELA;

CREATE TABLE Cliente (
	id int not null auto_increment primary key,
    nome varchar(45) not null,
    cpf varchar(45),
    endereco varchar(45) not null
);

INSERT INTO Cliente (nome, cpf, endereco) VALUES ("Robesvaldo", "231.783.193-03", "Avenida Sapucai");
INSERT INTO Cliente (nome, cpf, endereco) VALUES ("Terrencio", "912.342.353-92", "Bairro Anchieta");

ALTER TABLE Cliente ADD ano_nascimento INT;

UPDATE Cliente SET ano_nascimento = 2001 WHERE id = 1;
UPDATE Cliente SET ano_nascimento = 2000 WHERE id = 2;

DELETE FROM Cliente WHERE id = 1;

SELECT * FROM Cliente;
