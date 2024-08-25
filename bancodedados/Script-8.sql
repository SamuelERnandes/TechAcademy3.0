create database text_adventure;

create table Cena(
id_cena int primary key auto_increment, /* identificador das cena*/
nome varchar(100), /* nome da cena */
descricao text, /* descricao da cena */
status boolean /* controle para ver se a cena foi desbloqueada pelo usuario ou nao */

);

create table Item (
id_item int primary key auto_increment,
nome varchar(100),
descricao text,
tipo ENUM('cena', 'inventario'),
id_cena int,
foreign key(id_cena) references Cena(id_cena) 		

);

create table Jogador(
id_jogador int primary key auto_increment,
nick_name varchar(100),
inventario text,
progesso varchar(100),
estado boolean
);



show tables;