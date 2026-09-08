CREATE TABLE food_item (
    id            BIGINT       AUTO_INCREMENT PRIMARY KEY,
    nome          VARCHAR(255) NOT NULL,
    quantidade    INT          NOT NULL,
    validade      TIMESTAMP,
    categoria     VARCHAR(50),
    unidade_media VARCHAR(50),
    armazenamento VARCHAR(50)
);
