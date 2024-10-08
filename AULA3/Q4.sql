DROP DATABASE IF EXISTS teste;
CREATE DATABASE teste;
USE teste;

SET SQL_SAFE_UPDATES = 0;

# QUESTÃO 4
CREATE TABLE IF NOT EXISTS q4(
	matricula INT NOT NULL PRIMARY KEY,
    nome VARCHAR(45),
    endereco VARCHAR(45),
    ano_nasc INT,
    curso VARCHAR(45)
    );

# INSIRA AS INFORMAÇÕES NA TABELA
INSERT INTO q4 (matricula, nome, endereco, ano_nasc, curso) VALUES ('333','Carlos','Rua 0','2003','GEP');
INSERT INTO q4 (nome, matricula, endereco, ano_nasc, curso) VALUES ('Janaina','123','Rua 1','1998','GEB');
INSERT INTO q4 () VALUES ('453','Luca','Rua 2','2004','GES');
INSERT INTO q4 (nome, matricula, endereco, ano_nasc, curso) VALUES ('Paula','334','Rua 3','2000','GEC');
INSERT INTO q4 () VALUES ('225','Pedro','Rua 25','1999','GEA');
INSERT INTO q4 () VALUES ('109','Jander','Rua 10','2000','GES');
INSERT INTO q4 () VALUES ('342','Laura','Rua 3','2002','GEC');

#SELECT * FROM q4;

# BUSQUE NOME, MATRICULA E CURSO DOS ALUNOS CUJOS NOMES COMEÇAM COM 'JAN' E O NOME TENHA 7 LETRAS
SELECT nome,matricula,curso FROM q4 WHERE nome like 'Jan____%';

# BUSQUE O NOME E CURSO DOS ALUNOS CUJO NOME COMECE COM L E TERMINE COM A
SELECT nome,curso FROM q4 WHERE nome like 'L%A';

# BUSQUE O NOME, ANO_NASC E CURSO DE TODOS OS ALUNOS QUE TENHAM NASCIDO EM 2000 OU ANTES
SELECT nome,ano_nasc,curso FROM q4 WHERE ano_nasc <= 2000;

# BUSQUE TODAS AS INFORMAÇÕES DE TODOS OS ALUNOS, MAS RETORNE APENAS 4 REGISTROS
SELECT * FROM q4 limit 4;

# OS ALUNOS DO CURSO GES VÃO MORAR TODOS EM UMA REPUBLICA, ALTERE O ENDEREÇO DE TODOS ELES
UPDATE q4 SET endereco = 'Republica' WHERE curso = 'GES';
SELECT * FROM q4;

# OS ALUNOS DA REPUBLICA GES ESTAVAM FAZENDO MUITA FESTA E DESISTIRAM DO CURSO, DELETE TODOS ELES DA TABELA
DELETE FROM q4 WHERE curso = 'GES';
SELECT * FROM q4;
