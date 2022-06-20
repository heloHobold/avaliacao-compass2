CREATE DATABASE avaliacaoCompass2;

USE avaliacaoCompass2;

CREATE TABLE produto(
ID INT AUTO_INCREMENT NOT NULL,
NOME VARCHAR(80) NOT NULL,
DESCRICAO VARCHAR(150) NOT NULL,
QUANTIDADE INT NOT NULL,
PRECO FLOAT NOT NULL,
PRIMARY KEY (ID));

CREATE TABLE filme(
ID INT AUTO_INCREMENT NOT NULL,
NOME VARCHAR(80)NOT NULL,
DESCRICAO VARCHAR(150),
ANO varchar(4) NOT NULL,
PRIMARY KEY (ID));

INSERT INTO filme (nome, descricao, ano) VALUES
('IT A Coisa', 'Terror/Thriller ', '2017'),
('Jogada de Mestre', 'Crime/Drama', '2015'),
('Duna', 'Ficção científica/Aventura', '2021'),
('Fragmentado', 'Thriller/Terror', '2016'),
('O Menino Que Descobriu o Vento', 'Drama', '2019'),
('Logan', 'Ação/Ficção científica', '2017'),
('Os 101 Dálmatas - O Filme', 'Infantil/Comédia', '1996'),
('Extraordinário', 'Drama/Infantil', '2017'),
('Divergente', 'Ficção científica/Ação', '2014'),
('Como Eu Era Antes de Você', 'Romance/Drama', '2016'),
('Shrek', 'Comédia/Fantasia', '2001'),
('Doutor Estranho no Multiverso da Loucura', 'Ação/Aventura', '2022'),
('Star Wars - Guerra nas Estrelas', 'Ficção científica/Ação', '1977'),
('Homem-Aranha 3', 'Ação/Ficção científica', '2007'),
('Tá Chovendo Hambúrguer', 'Infantil/Comédia', '2009'),
('Rango', 'Infantil/Faroeste', '2011'),
('A Princesa e o Sapo', 'Musical/Infantil', '2009'),
('Titanic', 'Romance/Drama', '1997'),
('Piratas do Caribe: Navegando em Águas Misteriosas', 'Ação/Aventura', '2011'),
('Monstros S.A.', 'Comédia/Aventura', '2001'),
('Meu Namorado é um Zumbi', 'Terror/Romance ', '2013'),
('Encanto', 'Musical/Infantil', '2021'),
('Vingadores: Ultimato', 'Ação/Ficção científica', '2019'),
('Estrelas Além do Tempo', 'Drama/Ficção histórica', '2016'),
('A Fantástica Fábrica de Chocolate', 'Fantasia/Infantil', '2005'),
('A Fuga das Galinhas', 'Infantil/Comédia', '2000'),
('Por Água Abaixo', 'Infantil/Comédia', '2006'),
('Procurando Nemo', 'Infantil/Aventura', '2003'),
('Perdido em Marte', 'Ficção científica/Aventura', '2015'),
('O Senhor dos Anéis: A Sociedade do Anel', 'Fantasia/Aventura', '2001'),
('High School Musical', 'Musical/Infantil', '2006'),
('O Massacre da Serra Elétrica: O Retorno de Leatherface', 'Terror/Thriller', '2022'),
('Invocação do Mal', 'Terror/Thriller', '2013'),
('Ela Dança, Eu Danço', 'Dança/Musical', '2006'),
('Harry Potter e a Pedra Filosofal', 'Fantasia/Aventura', '2001'),
('Happy Feet', 'Infantil/Comédia', '2006'),
('Gravidade', 'Ficção científica/Thriller', '2003'),
('Ratatouille', 'Comédia/Infantil', '2007'),
('Interestelar', 'Ficção científica/Aventura', '2014'),
('Até o Último Homem', 'Guerra/Drama', '2016');