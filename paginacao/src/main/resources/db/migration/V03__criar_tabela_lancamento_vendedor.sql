CREATE TABLE vendedor(id_vendedor serial primary key, nome varchar(30));
INSERT INTO vendedor(nome) VALUES('Marcos');
INSERT INTO vendedor(nome) VALUES('Paula');
INSERT INTO vendedor(nome) VALUES('Ana Maria');

CREATE TABLE lancamento(id_lancamento serial primary key, data_lancamento date, total numeric, id_vendedor bigint,
FOREIGN KEY (id_vendedor) REFERENCES vendedor(id_vendedor));

INSERT INTO lancamento (data_lancamento,total,id_vendedor) VALUES ('2021-05-11',1500,1);
INSERT INTO lancamento (data_lancamento,total,id_vendedor) VALUES ('2021-05-12',3500,1);
INSERT INTO lancamento (data_lancamento,total,id_vendedor) VALUES ('2021-05-13',1000,2);
INSERT INTO lancamento (data_lancamento,total,id_vendedor) VALUES ('2021-05-13',500,2);