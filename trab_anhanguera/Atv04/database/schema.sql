CREATE DATABASE sistema_exemplo;

USE sistema_exemplo;

-- Acessando o Banco via PowerShell
cd "C:\Program Files\MySQL\MySQL Server 8.0\bin"
.\mysql -u root -p

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);

INSERT INTO clientes (nome, email) VALUES
('João Silva', 'joao@example.com'),
('Maria Oliveira', 'maria@example.com'),
('Carlos Souza', 'carlos@example.com');