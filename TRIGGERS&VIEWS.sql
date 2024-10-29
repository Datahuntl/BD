DROP DATABASE IF EXISTS loja;

CREATE DATABASE loja;

USE loja;

SET GLOBAL log_bin_trust_function_creators = 1;

CREATE TABLE IF NOT EXISTS compra(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    preco FLOAT,
    pagamento FLOAT,
    troco FLOAT
);

DELIMITER $$
CREATE TRIGGER troco_check BEFORE INSERT
ON compra
FOR EACH ROW
BEGIN

IF NEW.preco < NEW.pagamento THEN
SET NEW.troco = NEW.pagamento - NEW.preco;
ELSEIF NEW.preco = NEW.pagamento THEN
SET NEW.troco = 0;
END IF;

END; $$
DELIMITER ;

INSERT INTO compra(preco, pagamento) VALUES(9.5, 10.25);
INSERT INTO compra(preco, pagamento) VALUES(19.99, 25);
INSERT INTO compra(preco, pagamento) VALUES(5.99, 5.99);
INSERT INTO compra(preco, pagamento) VALUES(10.99, 10.99);
INSERT INTO compra(preco, pagamento) VALUES(15.99, 15.99);

CREATE VIEW CompraView AS (
	SELECT COUNT(*) FROM compra WHERE preco >= 10
);

DROP VIEW CompraView;

#SELECT * FROM CompraView;

SELECT * FROM compra;
