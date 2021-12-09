# Fundamentos Básicos de Java
O objetivo deste repositório é utilizar os recursos básicos que o java oferece sem a ajuda de um framework. Todas as linguagens de programação possuem frameworks ou libs para agilizarem o desenvolvimento e implementam boas práticas e padrões de projetos já consolidados. Em um dos projetos foi utilizado JDBC puro e no outro JPA que por debaixo dos panos utiliza JDBC.Nos dois projetos foi utilizado a mesma base de dados e o mesmo banco.

## Projeto que utiliza JDBC
### O que é JDBC?
É uma API que têm interfaces que facilitam a conexão com banco de dados, como a interface Connection, a execução de instruções sql com Statement ou PreparedStatement. Cada banco de dados possui o seu driver para fazer a communicação com o java.

### Pool de Conexão
São varias conexões que são abertas e encerradas com o banco de dados. Como é muito custoso abrir e fechar conexões 
manualmente, é boa prática utilizar pool de conexão.

### DAO(Data Access Object)
Padrão de projeto utilizado para consultar ou persistir dados em um banco de dados.

## Projeto que utiliza JPA
### O que é JPA(Java Persistence API)?
É uma especificação, mas o que é uma especificação?, uma especificação diz como algo deve ser feito ou seja especifica.

### O que é Hibernate?
É uma implementação, mas o que é uma implementação?, uma implementação é baseada em uma especificação.

### O que é Mavem?
É gerenciador de dependencias do java. Todo projeto que utiliza Mavem tem o arquivo pom.xml onde ficam as dependencias que o projeto utiliza e as suas versões.

### O que é o arquivo persistence.xml?
O que pode ser notado logo de cara é que este arquivo utiliza o driver do JDBC e este arquivo separa a configuração de acesso para o banco de dados.

## Banco de Dados foi executado em um container docker
Foi utilizado o banco de dados relacional MYSQL.
### Para criar um volume docker
``docker volume create <nome_do_volume>``

### Para criar uma rede no docker para que os containers possam se comunicarem.
``docker network create --driver <tipo_da_rede> bridge <nome_da_rede>``

### Para adiciionar os containers na rede criada.
``--network <nome_da_rede>``

### Executar o container com a imagem do mysql.
``docker run --name <nome_do_container> -v <nome_volume_que_vc_criou>:<nome_do_volune_do_container> -e MYSQL_ROOT_PASSWORD=<senha_db> -d -p 3306:3306 mysql``

### Variavel de ambiente
``-e``

### Bind de porta para comunicação do host com o container.
``-p <porta_do_host>:<porta_do_container>``

### Para não travar o terminal
``-d``

### Para acessar o container.
``docker exec -it <nome_do_volume> bash``

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
