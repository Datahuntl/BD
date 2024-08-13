DROP DATABASE IF EXISTS teste;
CREATE DATABASE teste;
USE teste;

# QUESTÃO 3
CREATE TABLE IF NOT EXISTS q3(
	matricula INT NOT NULL PRIMARY KEY,
    nome VARCHAR(45),
    endereco VARCHAR(45),
    ano_nasc INT,
    curso VARCHAR(45)
    );

# INSIRA AS INFORMAÇÕES NA TABELA
INSERT INTO q3 (matricula, nome, endereco, ano_nasc, curso) VALUES ('333','Carlos','Rua 0','2003','GEP');
INSERT INTO q3 (nome, matricula, endereco, ano_nasc, curso) VALUES ('Janaina','123','Rua 1','1998','GEB');
INSERT INTO q3 () VALUES ('453','Luca','Rua 2','2004','GES');
INSERT INTO q3 (nome, matricula, endereco, ano_nasc, curso) VALUES ('Paula','334','Rua 3','2000','GEC');

SELECT * FROM q3;
