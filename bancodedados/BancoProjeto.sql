create table text_adventurepj;

create table jogador (
ID_Jogador int primary key auto_increment, /*identificar cada jogador*/
Nome varchar(50), /*nome do jogador*/
Data_criacao DATETIME default CURRENT_TIMESTAMP /*DATATIME armazena a data e a hora do registro do banco e "DEFAULT CURRENT_TIMESTAMP" se nehuma data for especificada o banco vai completar automaticamente*/
);

create table item (
ID_Item int primary key auto_increment, /* identifica de forma unica cada item*/
NOME_Item varchar(50), /* nome do item*/
Descricao text /*descricao do item*/

);

create table Cena (
ID_Cena int primary key auto_increment, /* Identifica cada cena de forma unica*/
Descricao_cena text, /*Descricao da cena*/
Numero_cena int /* numero da cena*/
);

create table Comando (
ID_Comando int primary key auto_increment, /* identifica de forma unica cada comando*/
Nome_comando varchar(50), /* nome do comando*/
Descricao_comando text /*descricao do comando*/
);

create table Inventario (
ID_Inventario int primary key auto_increment, /* identifica de forma unica cada registro no inventario*/
ID_Jogador int, /*identifica qual o item ao jogador*/
ID_Item int, /* identifica o item no inventario*/
Quantidade int, /*quantidade de item no inventario*/
foreign key(ID_Jogador) references jogador(ID_Jogador),
foreign key(ID_Item) references item(ID_Item)
);

create table Jogo_salvo (
ID_Jogo_Salvo int primary key auto_increment, /* identifica de forma unica cada jogo salvo*/
ID_Jogador int, /* identifica qual o jogador que salvo*/
Data_Salvamento DATETIME default CURRENT_TIMESTAMP, /* grava a data e a hora do salvamento*/
ESTADO_Jogo text, /*salva o estado do jogo em que parou*/
foreign key(ID_Jogador) references jogador(ID_Jogador)
);

select * from Comando ;

insert into Comando(Nome_comando,Descricao_comando) values
('RESTART','Reinicia o jogo.')

