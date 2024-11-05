DROP DATABASE IF EXISTS AV2;
CREATE DATABASE IF NOT EXISTS AV2;
USE AV2;

CREATE TABLE Personagem (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    classe VARCHAR(50),
    descricao TEXT,
    nivel INT
);

CREATE TABLE Habilidade (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    tipo VARCHAR(50)
);

CREATE TABLE Personagem_Habilidade (
    personagem_id INT,
    habilidade_id INT,
    FOREIGN KEY (personagem_id) REFERENCES Personagem(id),
    FOREIGN KEY (habilidade_id) REFERENCES Habilidade(id),
    PRIMARY KEY (personagem_id, habilidade_id)
);

-- Questão 1
-- Crie uma function "criaDescricaoPersonagem" que recebe o nome, a classe e o nível de um personagem e retorna uma string com a descrição do personagem, contendo todas as informações.
-- Exemplo: "O personagem Gandalf é um Mago de nível 20."

DELIMITER $$
DROP FUNCTION IF EXISTS criaDescricaoPersonagem $$
CREATE FUNCTION criaDescricaoPersonagem(nome VARCHAR(100), classe VARCHAR(50), nivel INT) RETURNS  VARCHAR(100)
DETERMINISTIC
BEGIN
	DECLARE descricao VARCHAR(100);
    SET descricao = CONCAT('O personagem ', nome, ' é um ', classe, ' de nível ', nivel);
    RETURN descricao;
END$$
DELIMITER ;

-- Questão 2
-- Crie uma procedure "inserePersonagem" que recebe o nome, a classe e o nível de um personagem e insere um novo personagem na tabela Personagem, com a descrição gerada pela função "criaDescricaoPersonagem".

DELIMITER $$
DROP PROCEDURE IF EXISTS inserePersonagem $$
CREATE PROCEDURE inserePersonagem(nome VARCHAR(100), classe VARCHAR(50), nivel INT)
BEGIN
    DECLARE personagem VARCHAR(100);
    SET personagem = criaDescricaoPersonagem(nome, classe, nivel);
    INSERT INTO Personagem (nome, classe, descricao, nivel) VALUES (nome, classe, personagem, nivel);
END$$
DELIMITER ;

-- Questão 3
-- Faça a inserção de 3 personagens na tabela Personagem, utilizando a procedure "inserePersonagem".

CALL inserePersonagem('Jaquison', 'Mago', 3);
CALL inserePersonagem('Robisvaldo', 'Guerreiro', 1);
CALL inserePersonagem('Julho', 'Paladino', 2);

SELECT * FROM Personagem;

-- Questão 4
-- Faça a inserção de 3 habilidades na tabela Habilidade.

INSERT INTO Habilidade (descricao, tipo) VALUES('Aumenta a sua agilidade', 'Agilidade');
INSERT INTO Habilidade (descricao, tipo) VALUES('Aumenta a sua força', 'Força');
INSERT INTO Habilidade (descricao, tipo) VALUES('Aumenta a sua magia', 'Magia');

SELECT * FROM Habilidade;

-- Questão 5
-- Atribua 2 habilidades para cada personagem, utilizando a tabela Personagem_Habilidade.

INSERT INTO Personagem_Habilidade (personagem_id, habilidade_id) VALUES (1, 1);
INSERT INTO Personagem_Habilidade (personagem_id, habilidade_id) VALUES (1, 3);

INSERT INTO Personagem_Habilidade (personagem_id, habilidade_id) VALUES (2, 1);
INSERT INTO Personagem_Habilidade (personagem_id, habilidade_id) VALUES (2, 2);

INSERT INTO Personagem_Habilidade (personagem_id, habilidade_id) VALUES (3, 2);
INSERT INTO Personagem_Habilidade (personagem_id, habilidade_id) VALUES (3, 3);

SELECT * FROM Personagem_Habilidade;

-- Questão 6
-- Crie uma consulta que retorne todas as informações dos personagens e suas habilidades.

SELECT P.nome, P.classe, P.nivel, P.descricao, P.id, H.descricao, H.tipo, H.id FROM Personagem AS P JOIN Personagem_Habilidade AS PH ON P.id = PH.personagem_id JOIN Habilidade	AS H ON H.id = PH.habilidade_id;
