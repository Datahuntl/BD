CREATE DATABASE IF NOT EXISTS PROJETO;

USE PROJETO;

CREATE TABLE IF NOT EXISTS paciente (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  nome_mae VARCHAR(100),
  tipo_sangue VARCHAR(5)
);

CREATE TABLE IF NOT EXISTS medico (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  crm VARCHAR(20),
  especialidade VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS enfermeiro (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  coren VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS equipe_medica (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  medico_id INT,
  FOREIGN KEY (medico_id) REFERENCES medico(id)
);

CREATE TABLE IF NOT EXISTS paciente_equipe_medica (
  paciente_id INT,
  equipe_medica_id INT,
  PRIMARY KEY (paciente_id, equipe_medica_id),
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (equipe_medica_id) REFERENCES equipe_medica(id)
);

CREATE TABLE IF NOT EXISTS enfermeiro_equipe_medica (
  enfermeiro_id INT,
  equipe_medica_id INT,
  PRIMARY KEY (enfermeiro_id, equipe_medica_id),
  FOREIGN KEY (enfermeiro_id) REFERENCES enfermeiro(id),
  FOREIGN KEY (equipe_medica_id) REFERENCES equipe_medica(id)
);

SELECT * FROM paciente;
SELECT * FROM medico;
SELECT * FROM enfermeiro;
SELECT * FROM equipe_medica;
SELECT * FROM paciente_equipe_medica;
SELECT * FROM enfermeiro_equipe_medica;
