# Fundamentos Java
O objetivo deste repositório é utilizar os recursos básicos que o java oferece sem a ajuda ou abstração de um framework.

## Como conectar em um banco de dados com java
### O que é JDBC?
É uma API que têm interfaces que facilitam a conexão com banco de dados, como a interface Connection, a execução de instruções sql com Statement ou PreparedStatement. Cada banco de dados possui o seu driver para fazer a communicação com o java.

### Pool de Conexão
São varias conexões que são abertas e encerradas com o banco de dados. Como é muito custoso abrir e fechar conexões 
manualmente, é boa prática utilizar pool de conexão.

### DAO
É um padrão utilizado para ter acesso aos dados do banco de dados.

## Banco de Dados Mysql
Banco de dados relacional(baseado em tabelas e elas podem ter relacionamentos ou não). O mysql está sendo executado em um container docker.

Comandos utilizados para executar o banco de dados mysql em um container docker.

## Comandos Docker

### Para criar um volume docker
docker volume create <nome_do_volume>

### Executar o container com a imagem do mysql.
``docker run --name <nome_do_container> -v <nome_volume_que_vc_criou>:<nome_do_volune_do_container> -e MYSQL_ROOT_PASSWORD=<senha_db> -d -p 3306:3306 mysql``

### Variavel de ambiente
-e

### Bind de porta para comunicação do host com o container.
-p <porta_do_host>:<porta_do_container>

### Para não travar o terminal
-d

### Executar comandos no container.
docker exec -it <nome_do_volume> bash

### Acessar banco de dados
``mysql -u root -p``

### Vai pedir a senha 
Digite a mesma senha que vc utilizou ao iniciar o container.

### Mostra todos os BD.
``show databases;``

### Cria banco de dados.
``CREATE DATABASE <nome_do_BD>;``

### Para acessar o banco de dados.
``USE <nome_do_db>;``

### Cria tabela de cliente.
``CREATE TABLE customer(
id int AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(45) NOT NULL,
cpf VARCHAR(12) NOT NULL,
occupation VARCHAR(25) NOT NULL
)Engine = InnoDB;``

### Cria tabela de categoria
``CREATE TABLE category(
id int AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR(45) NOT NULL
)Engine = InnoDB;``

### Cria tabela de produto
``CREATE TABLE product(
id int AUTO_INCREMENT PRIMARY KEY,
product_name VARCHAR(45) NOT NULL,
description VARCHAR(55) NOT NULL
)Engine = InnoDB;``

### Insere dados nas tabelas cliente, categoria e produto.
``INSERT INTO product(product_name, description, category_id) VALUES('notbook', 'preto tela 14 polegadas', 2);``</br>
``INSERT INTO product(product_name, description, category_id) VALUES('geladeira', 'branca 336 litros', 1);``</br>
``INSERT INTO category(category_name) VALUES('eletrodomestico');``</br>
``INSERT INTO category(category_name) VALUES('informatica');``</br>
``INSERT INTO customer(name, cpf, occupation) VALUES ('Suele', '11111111111', 'desenvolvedora');``</br>
