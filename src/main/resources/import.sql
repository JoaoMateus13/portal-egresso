INSERT INTO egresso (nome, email, descricao, foto, linkedin, instagam, curriculo) VALUES ('João Silva', 'joao.silva@example.com', 'Descrição do João', 'foto1.jpg', 'linkedin.com/joao', 'instagram.com/joao', 'curriculo1.pdf');

INSERT INTO egresso (nome, email, descricao, foto, linkedin, instagam, curriculo) VALUES ('Maria Souza', 'maria.souza@example.com', 'Descrição da Maria', 'foto2.jpg', 'linkedin.com/maria', 'instagram.com/maria', 'curriculo2.pdf');

INSERT INTO egresso (nome, email, descricao, foto, linkedin, instagam, curriculo) VALUES ('José Santos', 'josé.santos@example.com', 'Descrição do José', 'foto3.jpg', 'linkedin.com/jose', 'instagram.com/jose', 'curriculo3.pdf');

INSERT INTO coordenador (login, senha, tipo) VALUES ('admin', 'admin', 'ADMIN');

INSERT INTO curso (nome, nivel, id_coordenador) VALUES ('Engenharia de Software', 'Graduação', 1);

INSERT INTO curso (nome, nivel, id_coordenador) VALUES ('Ciência da Computação', 'Graduação', 1);

INSERT INTO cargo (descricao, local, ano_inicio, ano_fim, id_egresso) VALUES ('Desenvolvedor', 'Empresa X', 2015, 2018, (SELECT id_egresso FROM egresso WHERE nome = 'João Silva'));

INSERT INTO cargo (descricao, local, ano_inicio, ano_fim, id_egresso) VALUES ('Analista de Sistemas', 'Empresa Y', 2019, 2021, (SELECT id_egresso FROM egresso WHERE nome = 'Maria Souza'));

INSERT INTO depoimento (texto, date, id_egresso) VALUES ('Depoimento do João', '2023-01-01', (SELECT id_egresso FROM egresso WHERE nome = 'João Silva'));

INSERT INTO depoimento (texto, date, id_egresso) VALUES ('Depoimento da Maria', '2023-02-01', (SELECT id_egresso FROM egresso WHERE nome = 'Maria Souza'));

INSERT INTO curso_egresso (id_curso, id_egresso, ano_inicio, ano_fim) VALUES (1, 1, 2010, 2014);

INSERT INTO curso_egresso (id_curso, id_egresso, ano_inicio, ano_fim) VALUES (2, 2, 2011, 2015);

