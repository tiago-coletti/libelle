ALTER TABLE usuario 
ADD COLUMN email_verificado BOOLEAN NOT NULL DEFAULT FALSE;

ALTER TABLE usuario 
ADD COLUMN codigo_verificacao  VARCHAR(10);

ALTER Table usuario
ADD COLUMN codigo_expiracao DATETIME;