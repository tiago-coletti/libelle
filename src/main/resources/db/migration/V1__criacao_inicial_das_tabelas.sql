CREATE TABLE IF NOT EXISTS localidade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    status_aprovacao ENUM('PENDENTE', 'APROVADO') NOT NULL DEFAULT 'PENDENTE'
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ortografia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_sistema VARCHAR(100) NOT NULL UNIQUE,
    descricao TEXT
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS verbete (
    id INT AUTO_INCREMENT PRIMARY KEY,
    classe_gramatical VARCHAR(50),
    genero VARCHAR(10),
    notas_linguisticas TEXT
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    nivel_acesso ENUM('USUARIO', 'MANAGER', 'ADMIN') NOT NULL DEFAULT 'USUARIO',
    localidade_id INT,
    preferencia_ortografia_id INT,
    ano_nascimento INT,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (localidade_id) REFERENCES localidade(id),
    FOREIGN KEY (preferencia_ortografia_id) REFERENCES ortografia(id)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS audio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_autor_id INT NOT NULL,
    caminho_arquivo VARCHAR(255) NOT NULL UNIQUE,
    status_moderacao ENUM('PENDENTE', 'APROVADO', 'REJEITADO') NOT NULL DEFAULT 'PENDENTE',
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (usuario_autor_id) REFERENCES usuario(id)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS log_moderacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_moderador_id INT NOT NULL,
    tipo_alvo ENUM('AUDIO', 'EXEMPLO', 'VERBETE', 'LOCALIDADE', 'VARIACAO', 'SUGESTAO') NOT NULL,
    id_alvo INT NOT NULL,
    acao ENUM('APROVOU', 'REJEITOU', 'EDITOU', 'CRIOU') NOT NULL,
    data_acao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (usuario_moderador_id) REFERENCES usuario(id)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS variacao_ortografica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    verbete_id INT NOT NULL,
    ortografia_id INT NOT NULL,
    grafia_alternativa VARCHAR(255) NOT NULL,
    is_principal BOOLEAN NOT NULL DEFAULT FALSE,

    FOREIGN KEY (verbete_id) REFERENCES verbete(id) ON DELETE CASCADE,
    FOREIGN KEY (ortografia_id) REFERENCES ortografia(id),

    UNIQUE KEY uk_principal_por_ortografia (verbete_id, ortografia_id, is_principal),
    INDEX idx_grafia (grafia_alternativa)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS traducao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    verbete_id INT NOT NULL,
    texto_traducao VARCHAR(255) NOT NULL,
    contexto VARCHAR(100),

    FOREIGN KEY (verbete_id) REFERENCES verbete(id) ON DELETE CASCADE
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS exemplo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    verbete_id INT NOT NULL,
    texto_original TEXT NOT NULL,
    texto_traducao TEXT,
    usuario_autor_id INT NOT NULL,
    status_moderacao ENUM('PENDENTE', 'APROVADO', 'REJEITADO') NOT NULL DEFAULT 'PENDENTE',
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (verbete_id) REFERENCES verbete(id),
    FOREIGN KEY (usuario_autor_id) REFERENCES usuario(id)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS sugestao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    tipo_sugestao ENUM('VERBETE_NOVO', 'TRADUCAO_NOVA') NOT NULL,
    verbete_id_associado INT,
    texto_principal VARCHAR(255) NOT NULL,
    texto_secundario VARCHAR(255),
    contexto_sugestao TEXT,
    status_moderacao ENUM('PENDENTE', 'REVISADO', 'REJEITADO') NOT NULL DEFAULT 'PENDENTE',
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (verbete_id_associado) REFERENCES verbete(id)
    ) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS audio_verbete (
    audio_id INT NOT NULL,
    verbete_id INT NOT NULL,

    PRIMARY KEY (audio_id, verbete_id),
    FOREIGN KEY (audio_id) REFERENCES audio(id) ON DELETE CASCADE,
    FOREIGN KEY (verbete_id) REFERENCES verbete(id) ON DELETE CASCADE
    ) ENGINE=InnoDB;