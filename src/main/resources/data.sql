insert into categoria values (1, 'Drama');
insert into categoria values (2, 'Terror');

insert into autor (id, nome, email, descricao, instante_criacao) values (1, 'João Alberto', 'joaoalberto@gmail.com', 'autor fodastico', '2021-04-22');
insert into autor (id, nome, email, descricao, instante_criacao) values (2, 'Joana Nobrega', 'joananobrega@gmail.com', 'autora fodastica', '2021-04-22');

insert into livro (id, titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, id_categoria, id_autor) values (1, 'João e Maria', 'João e maria é um livro bacana e tal', '', 105.00, 200, 1234567891235, '2022-01-04', 1, 1);
insert into livro (id, titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, id_categoria, id_autor) values (2, 'Caça as bruxas', 'Livro de terror', '', 250.72, 600, 987654321654, '2021-05-04', 2, 2);

insert into pais (id, nome) values (1, 'Brasil');
insert into pais (id, nome) values (2, 'Estados Unidos');

insert into estado (id, nome, id_pais) values (1, 'São Paulo', 1);
insert into estado (id, nome, id_pais) values (2, 'Arizona', 2);
