INSERT INTO egresso (id_egresso, nome, email, descricao, foto, linkedin, instagam, curriculo) VALUES (1, 'João Silva', 'joao.silva@example.com', 'Descrição do João', 'foto1.jpg', 'linkedin.com/joao', 'instagram.com/joao', 'curriculo1.pdf');
INSERT INTO egresso (id_egresso, nome, email, descricao, foto, linkedin, instagam, curriculo) VALUES (2, 'Maria Souza', 'maria.souza@example.com', 'Descrição da Maria', 'foto2.jpg', 'linkedin.com/maria', 'instagram.com/maria', 'curriculo2.pdf');

-- Dados para a tabela 'curso'
INSERT INTO curso (id_curso, nome, nivel) VALUES (1, 'Engenharia de Software', 'Graduação');
INSERT INTO curso (id_curso, nome, nivel) VALUES (2, 'Ciência da Computação', 'Graduação');

-- Dados para a tabela 'cargo'
INSERT INTO cargo (id_cargo, descricao, local, ano_inicio, ano_fim, id_egresso) VALUES (1, 'Desenvolvedor', 'Empresa X', 2015, 2018, 1);
INSERT INTO cargo (id_cargo, descricao, local, ano_inicio, ano_fim, id_egresso) VALUES (2, 'Analista de Sistemas', 'Empresa Y', 2019, 2021, 2);

-- Dados para a tabela 'depoimento'
INSERT INTO depoimento (id_depoimento, texto, date, id_egresso) VALUES (1, 'Depoimento do João', '2023-01-01', 1);
INSERT INTO depoimento (id_depoimento, texto, date, id_egresso) VALUES (2, 'Depoimento da Maria', '2023-02-01', 2);

-- Dados para a tabela 'curso_egresso'
INSERT INTO curso_egresso (id_curso, id_egresso, ano_inicio, ano_fim) VALUES (1, 1, 2010, 2014);
INSERT INTO curso_egresso (id_curso, id_egresso, ano_inicio, ano_fim) VALUES (2, 2, 2011, 2015);