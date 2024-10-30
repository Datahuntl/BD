CREATE TABLE ex1(
    cod_item INT NOT NULL PRIMARY KEY,
    nome VARCHAR(45),
    preco FLOAT,
    quantidade INT
);

INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("1", "Arco", "20", "22");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("2", "Flecha", "2", "43");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("3", "Espada", "35", "16");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("4", "Escudo", "20", "20");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("5", "Maça", "23", "19");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("6", "Mangual", "56", "16");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("7", "Lança", "21", "18");
INSERT INTO ex1 (cod_item,nome,preco,quantidade) VALUES("8", "Machado", "20", "21");

SELECT * FROM ex1;
