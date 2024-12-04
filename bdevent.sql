-- Criação do banco de dados
CREATE DATABASE evento_db;
 
-- Selecionando o banco de dados
USE evento_db;
 
-- Tabela de Pessoa (para Organizador e Participante)
CREATE TABLE Pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    tipo VARCHAR(50), -- Organizador ou Participante
    departamento VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(20)
);
 
-- Tabela de Eventos (informações sobre o evento)
CREATE TABLE Evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    descricao TEXT,
    data_inicio DATETIME,
    data_fim DATETIME
);
 
-- Tabela de Local (informações sobre os locais de evento)
CREATE TABLE Local (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    endereco VARCHAR(200)
);
 
-- Tabela de Notificação (para enviar notificações aos participantes)
CREATE TABLE Notificacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50), -- Tipo de notificação (Ex: Email, SMS, etc)
    mensagem VARCHAR(255),
    data_envio DATETIME DEFAULT CURRENT_TIMESTAMP
);
 
-- Tabela de Participantes do Evento (relacionamento entre Participante e Evento)
CREATE TABLE Evento_Participante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    evento_id INT,
    participante_id INT,
    FOREIGN KEY (evento_id) REFERENCES Evento(id) ON DELETE CASCADE,
    FOREIGN KEY (participante_id) REFERENCES Pessoa(id) ON DELETE CASCADE
);
 
-- Tabela de Organizadores do Evento (relacionamento entre Organizador e Evento)
CREATE TABLE Evento_Organizador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    evento_id INT,
    organizador_id INT,
    FOREIGN KEY (evento_id) REFERENCES Evento(id) ON DELETE CASCADE,
    FOREIGN KEY (organizador_id) REFERENCES Pessoa(id) ON DELETE CASCADE
);
 
-- Inserção de dados iniciais - Exemplo de evento e pessoa
INSERT INTO Evento (nome, descricao, data_inicio, data_fim)
VALUES ('Festa de Aniversário', 'Evento de comemoração de aniversário', '2024-12-25 18:00:00', '2024-12-25 22:00:00');
 
-- Inserção de pessoas (Organizador e Participante)
INSERT INTO Pessoa (nome, tipo, departamento, email, telefone)
VALUES ('Carlos Silva', 'Organizador', 'Marketing', 'carlos.silva@example.com', '123456789'),
       ('João Pereira', 'Participante', 'Vendas', 'joao.pereira@example.com', '987654321');
 
-- Associando um Organizador a um Evento
INSERT INTO Evento_Organizador (evento_id, organizador_id)
VALUES (1, 1);
 
-- Associando um Participante a um Evento
INSERT INTO Evento_Participante (evento_id, participante_id)
VALUES (1, 2);
 
-- Inserção de um Local para o evento
INSERT INTO Local (nome, endereco)
VALUES ('Salão de Eventos', 'Rua das Flores, 123');
 
-- Inserção de Notificação
INSERT INTO Notificacao (tipo, mensagem)
VALUES ('Email', 'Você foi convidado para o evento de Aniversário!');