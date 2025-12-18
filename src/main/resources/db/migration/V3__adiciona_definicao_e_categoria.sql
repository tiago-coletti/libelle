-- V3__adiciona_definicao_e_categoria.sql

ALTER TABLE traducao ADD COLUMN definicao TEXT;

-- 2. Criar sistema de Categorias (Tags)
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE verbete_categoria (
    verbete_id INT NOT NULL,
    categoria_id INT NOT NULL,
    PRIMARY KEY (verbete_id, categoria_id),
    FOREIGN KEY (verbete_id) REFERENCES verbete(id) ON DELETE CASCADE,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE CASCADE
);