-- 1. Garante que existe um usuário para assinar os exemplos
INSERT INTO usuario (id, nome_completo, email, senha_hash, nivel_acesso)
VALUES (1, 'Admin Libelle', 'admin@libelle.com', 'hash_senha_segura', 'ADMIN')
    ON DUPLICATE KEY UPDATE id=id;

INSERT INTO ortografia (id, nome_sistema, descricao)
VALUES (1, 'Ortografia Piter Kehoma Boll', 'Sistema ortográfico baseado na etimologia alemã e fonética tradicional, utilizado no Dicionário Hunsriqueano Riograndense–Português (2021).');

-- 3. Inserção dos Verbetes (Gramática)
INSERT INTO verbete (id, classe_gramatical, genero) VALUES
                                                        (1, 'substantivo', 'm.'), -- Aadler
                                                        (2, 'substantivo', 'm.'), -- Aanfang
                                                        (3, 'verbo', NULL),       -- aanfange
                                                        (4, 'substantivo', 'f.'), -- Aarvet
                                                        (5, 'substantivo', 'm.'), -- Baam
                                                        (6, 'verbo', NULL),       -- backe
                                                        (7, 'substantivo', 'm.'), -- Ball
                                                        (8, 'substantivo', 'm.'), -- Bauch
                                                        (9, 'verbo', NULL),       -- beise
                                                        (10, 'substantivo', 'n.'), -- Bett
                                                        (11, 'substantivo', 'n.'), -- Bier
                                                        (12, 'substantivo', 'n.'), -- Bild
                                                        (13, 'verbo', NULL),       -- binne
                                                        (14, 'substantivo', 'n.'), -- Blud
                                                        (15, 'substantivo', 'f.'), -- Blumm
                                                        (16, 'substantivo', 'n.'), -- Brod
                                                        (17, 'substantivo', 'm.'), -- Bruder
                                                        (18, 'substantivo', 'n.'), -- Buch
                                                        (19, 'substantivo', 'm.'), -- Daagh
                                                        (20, 'substantivo', 'n.'), -- Dach
                                                        (21, 'verbo', NULL),       -- danze
                                                        (22, 'substantivo', 'n.'), -- Deitsch
                                                        (23, 'verbo', NULL),       -- denke
                                                        (24, 'substantivo', 'n.'), -- Dier
                                                        (25, 'substantivo', 'm.'), -- Dokter
                                                        (26, 'substantivo', 'm.'), -- Dorst
                                                        (27, 'substantivo', 'm.'), -- Dunst
                                                        (28, 'substantivo', 'm.'), -- Fisch
                                                        (29, 'verbo', NULL),       -- fische
                                                        (30, 'substantivo', 'f.'); -- Flasch

-- 4. Inserção das Variações (A grafia exata do Piter)
INSERT INTO variacao_ortografica (verbete_id, ortografia_id, grafia_alternativa, is_principal) VALUES
                                                                                                   (1, 1, 'Aadler', TRUE),
                                                                                                   (2, 1, 'Aanfang', TRUE),
                                                                                                   (3, 1, 'aanfange', TRUE),
                                                                                                   (4, 1, 'Aarvet', TRUE),
                                                                                                   (5, 1, 'Baam', TRUE),
                                                                                                   (6, 1, 'backe', TRUE),
                                                                                                   (7, 1, 'Ball', TRUE),
                                                                                                   (8, 1, 'Bauch', TRUE),
                                                                                                   (9, 1, 'beise', TRUE),
                                                                                                   (10, 1, 'Bett', TRUE),
                                                                                                   (11, 1, 'Bier', TRUE),
                                                                                                   (12, 1, 'Bild', TRUE),
                                                                                                   (13, 1, 'binne', TRUE),
                                                                                                   (14, 1, 'Blud', TRUE),
                                                                                                   (15, 1, 'Blumm', TRUE),
                                                                                                   (16, 1, 'Brod', TRUE),
                                                                                                   (17, 1, 'Bruder', TRUE),
                                                                                                   (18, 1, 'Buch', TRUE),
                                                                                                   (19, 1, 'Daagh', TRUE),
                                                                                                   (20, 1, 'Dach', TRUE),
                                                                                                   (21, 1, 'danze', TRUE),
                                                                                                   (22, 1, 'Deitsch', TRUE),
                                                                                                   (23, 1, 'denke', TRUE),
                                                                                                   (24, 1, 'Dier', TRUE),
                                                                                                   (25, 1, 'Dokter', TRUE),
                                                                                                   (26, 1, 'Dorst', TRUE),
                                                                                                   (27, 1, 'Dunst', TRUE),
                                                                                                   (28, 1, 'Fisch', TRUE),
                                                                                                   (29, 1, 'fische', TRUE),
                                                                                                   (30, 1, 'Flasch', TRUE);

-- 5. Inserção das Traduções e Definições (Extraídas do PDF)
INSERT INTO traducao (verbete_id, texto_traducao, definicao) VALUES
                                                                 (1, 'águia', 'Ave de rapina de grande porte [Zool].'),
                                                                 (2, 'início', 'Começo, parte inicial de algo.'),
                                                                 (3, 'começar', 'Iniciar uma ação.'),
                                                                 (4, 'trabalho', 'Emprego, ocupação.'),
                                                                 (5, 'árvore', 'Planta lenhosa de grande porte [Bot].'),
                                                                 (6, 'assar', 'Cozinhar em forno; também usado para fritar em alguns contextos.'),
                                                                 (7, 'bola', 'Objeto esférico, especialmente para praticar esportes.'),
                                                                 (8, 'barriga', 'Abdome, ventre [Anat].'),
                                                                 (9, 'morder', 'Dar uma mordida.'),
                                                                 (10, 'cama', 'Móvel para dormir.'),
                                                                 (11, 'cerveja', 'Bebida alcoólica fermentada.'),
                                                                 (12, 'figura', 'Imagem, foto, fotografia, gravura.'),
                                                                 (13, 'amarrar', 'Atar, prender com corda.'),
                                                                 (14, 'sangue', 'Líquido vital que circula no corpo [Anat].'),
                                                                 (15, 'flor', 'Estrutura reprodutiva das plantas [Bot].'),
                                                                 (16, 'pão', 'Alimento feito de massa de farinha assada [Cul].'),
                                                                 (17, 'irmão', 'Filho dos mesmos pais.'),
                                                                 (18, 'livro', 'Conjunto de folhas encadernadas.'),
                                                                 (19, 'dia', 'Período de 24 horas ou período claro do dia.'),
                                                                 (20, 'telhado', 'Cobertura de uma casa.'),
                                                                 (21, 'dançar', 'Mover o corpo com ritmo.'),
                                                                 (22, 'alemão', 'Língua alemã.'),
                                                                 (23, 'pensar', 'Achar, supor, raciocinar.'),
                                                                 (24, 'animal', 'Ser vivo do reino animal [Zool].'),
                                                                 (25, 'médico', 'Doutor, profissional da medicina [Med].'),
                                                                 (26, 'sede', 'Necessidade de beber líquidos.'),
                                                                 (27, 'névoa', 'Vapor, neblina.'),
                                                                 (28, 'peixe', 'Animal aquático vertebrado [Zool].'),
                                                                 (29, 'pescar', 'Apanhar peixes.'),
                                                                 (30, 'garrafa', 'Recipiente para líquidos; no diminutivo (Fleschje) significa mamadeira.');

-- 6. Inserção de Exemplos (Frases originais do Piter Kehoma Boll)
INSERT INTO exemplo (verbete_id, usuario_autor_id, texto_original, texto_traducao, status_moderacao) VALUES
                                                                                                         (1, 1, 'De Aadler fliehd hogh.', 'A águia voa alto.', 'APROVADO'),
                                                                                                         (2, 1, 'Aller Aanfang is schwäer.', 'Todo começo é difícil.', 'APROVADO'),
                                                                                                         (3, 1, 'Die Mussik fangd aan.', 'A música está começando.', 'APROVADO'),
                                                                                                         (4, 1, 'Ich suche Aarvet.', 'Estou procurando emprego.', 'APROVADO'),
                                                                                                         (5, 1, 'Die Katz is uffem Baam.', 'O gato está sobre a árvore.', 'APROVADO'),
                                                                                                         (6, 1, 'Mein Mutter backd Brod.', 'Minha mãe está assando pão.', 'APROVADO'),
                                                                                                         (7, 1, 'Die Kinner spiele mim Ball.', 'As crianças brincam com a bola.', 'APROVADO'),
                                                                                                         (8, 1, 'De Mann hod en grose Bauch.', 'O homem tem uma barriga grande.', 'APROVADO'),
                                                                                                         (9, 1, 'Unser Hund beisd.', 'Nosso cão morde.', 'APROVADO'),
                                                                                                         (10, 1, 'das Bett mache.', 'Arrumar a cama.', 'APROVADO'),
                                                                                                         (11, 1, 'en Bier drinke.', 'Beber uma cerveja.', 'APROVADO'),
                                                                                                         (12, 1, 'en Buch foll Bilder.', 'Um livro cheio de figuras.', 'APROVADO'),
                                                                                                         (13, 1, 'de Strick aan de Baam binne.', 'Amarrar a corda na árvore.', 'APROVADO'),
                                                                                                         (14, 1, 'die Wand waar foll Blud.', 'A parede estava cheia de sangue.', 'APROVADO'),
                                                                                                         (15, 1, 'die Blumm is aarich scheen.', 'A flor é muito bonita.', 'APROVADO'),
                                                                                                         (16, 1, 'Ich backe Brod.', 'Eu asso pão.', 'APROVADO'),
                                                                                                         (17, 1, 'Ich hon en kleener Bruder.', 'Tenho um irmão pequeno.', 'APROVADO'),
                                                                                                         (18, 1, 'Was fer Buch dust-du lese?', 'Qual livro você está lendo?', 'APROVADO'),
                                                                                                         (19, 1, 'Er hod de ganz Daagh geschlof.', 'Ele dormiu o dia inteiro.', 'APROVADO'),
                                                                                                         (20, 1, 'Die Katz laufd uffem Dach.', 'O gato está andando no telhado.', 'APROVADO'),
                                                                                                         (21, 1, 'Meer gehn danze.', 'Estamos indo dançar.', 'APROVADO'),
                                                                                                         (22, 1, 'Sprechst-du Deitsch?', 'Você fala Alemão?', 'APROVADO'),
                                                                                                         (23, 1, 'Ich denke aan etwas.', 'Eu penso em algo.', 'APROVADO'),
                                                                                                         (24, 1, 'Was fer Dier is das?', 'Que animal é esse?', 'APROVADO'),
                                                                                                         (25, 1, 'Er muss bei de Dokter gehn.', 'Ele precisa ir ao médico.', 'APROVADO'),
                                                                                                         (26, 1, 'Ich hon Dorst.', 'Estou com sede.', 'APROVADO'),
                                                                                                         (27, 1, 'Wechem Dunst konnd-ma nichs sihn.', 'Por causa da névoa não se pôde ver nada.', 'APROVADO'),
                                                                                                         (28, 1, 'Heit esse-mer Fisch.', 'Hoje comeremos peixe.', 'APROVADO'),
                                                                                                         (29, 1, 'Moie gehm-mer fische.', 'Amanhã vamos pescar.', 'APROVADO'),
                                                                                                         (30, 1, 'Sie hod en Flasch Wein kried.', 'Ela ganhou uma garrafa de vinho.', 'APROVADO');