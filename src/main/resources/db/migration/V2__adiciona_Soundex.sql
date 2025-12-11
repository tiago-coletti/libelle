-- V2__adiciona_Soundex.sql

ALTER TABLE variacao_ortografica ADD COLUMN codigo_fonetico VARCHAR(10);
CREATE INDEX idx_variacao_fonetica ON variacao_ortografica(codigo_fonetico);