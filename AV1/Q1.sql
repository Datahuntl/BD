DROP DATABASE IF EXISTS AV1;
CREATE DATABASE AV1;
USE AV1;

#COMANDO PARA DESATIVAR O SAFE MODE
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE IF NOT EXISTS Ninja (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    dinheiro INT NOT NULL,
    tipoChakra VARCHAR(50) NOT NULL,
    qtdChakra INT NOT NULL
);

# Responda aqui a letra A
INSERT INTO Ninja (nome, idade, titulo, dinheiro, tipoChakra, qtdChakra) VALUES ("Naruto", 13, "Genin", 0, "Vento", 600);
INSERT INTO Ninja (nome, idade, titulo, dinheiro, tipoChakra, qtdChakra) VALUES ("Sasuke", 14, "Chunin", 500, "Raio", 400);
INSERT INTO Ninja (nome, idade, titulo, dinheiro, tipoChakra, qtdChakra) VALUES ("Sakura", 12, "Genin", 150, "Terra", 500);
INSERT INTO Ninja (nome, idade, titulo, dinheiro, tipoChakra, qtdChakra) VALUES ("Gaara", 15, "Chunin", 400, "Areia", 550);
INSERT INTO Ninja (nome, idade, titulo, dinheiro, tipoChakra, qtdChakra) VALUES ("Kakashi", 28, "Jonin", 1000, "Raio", 200);
INSERT INTO Ninja (nome, idade, titulo, dinheiro, tipoChakra, qtdChakra) VALUES ("Minato", 35, "Hokage", 5000, "Vento", 300);
#SELECT * FROM Ninja;

# Responda aqui a letra B - Atualize a idade do naruto para 14
UPDATE Ninja SET idade = 14 WHERE id = 1;
#SELECT * FROM Ninja;

# Responda aqui a letra C - Busque todos os dados dos ninjas com titulo "genin"
SELECT * FROM Ninja WHERE titulo LIKE "Genin";

# Responda aqui a letra D - Delete o ninja com a quantidade de Chakra igual a 550
DELETE FROM Ninja WHERE qtdChakra = 550;
#SELECT * FROM Ninja;

# Responda aqui a letra E - Busque o titulo dos ninjas com o tipo chakra "vento"
SELECT titulo FROM Ninja WHERE tipoChakra LIKE "Vento";

# Responda aqui a letra F - Busque a idade maxima entre os ninjas 
SELECT idade FROM Ninja;

# Responda aqui a letra G - Atualize o titulo do Naruto e da Sakura para "Chunin"
UPDATE Ninja SET titulo = "Chunin" WHERE titulo = "Genin";
#SELECT * FROM Ninja;

# Responda aqui a letra H - Busque todos os nomes que começam com "Sa" e tenhma 6 letras
SELECT nome FROM Ninja WHERE nome like "Sa____%";

# Responda aqui a letra I - Busque quantos ninjas tem valor de dinheiro igual ou menor a 1000
SELECT COUNT(dinheiro) FROM Ninja WHERE dinheiro <= 1000;
