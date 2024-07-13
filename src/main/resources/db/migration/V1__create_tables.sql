CREATE TABLE IF NOT EXISTS usuarios (
    id    SERIAL PRIMARY KEY,
    nome  VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR
);

CREATE TABLE IF NOT EXISTS listas(
    id         SERIAL PRIMARY KEY,
    usuario_id INT,
    titulo     VARCHAR(100) NOT NULL,
    descricao  VARCHAR,

    CONSTRAINT fk_listas_usuarios
              FOREIGN KEY(usuario_id)
                REFERENCES usuarios(id)
);

CREATE TABLE IF NOT EXISTS tipos(
    id   SERIAL PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS apiconsumida(
    id  SERIAL PRIMARY KEY,
    api VARCHAR(100) NOT NULL,
    url VARCHAR
);

CREATE TABLE IF NOT EXISTS pais(
    id    SERIAL PRIMARY KEY,
    nome  VARCHAR(100) NOT NULL,
    sigla VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS status(
    id     SERIAL PRIMARY KEY,
    status VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS registros(
    id SERIAL PRIMARY KEY,
    lista_id INT,
    poster VARCHAR,
    nome VARCHAR,
    sinopse VARCHAR,
    tipo_id INT,
    apiconsumida_id INT,
    pais_id INT,
    status_id INT,
    temporadas INT,
    total_episodios INT,
    episodios_assistidos INT,
    rating INT,
    comentarios VARCHAR,
    data_comeco DATE,
    data_final DATE,
    data_registro DATE NOT NULL DEFAULT CURRENT_DATE,

    CONSTRAINT fk_registros_lista
          FOREIGN KEY(lista_id)
            REFERENCES listas(id),

    CONSTRAINT fk_registros_tipos
              FOREIGN KEY(tipo_id)
                REFERENCES tipos(id),


    CONSTRAINT fk_registros_apiconsumidas
          FOREIGN KEY(apiconsumida_id)
            REFERENCES apiconsumida(id),

    CONSTRAINT fk_registros_pais
              FOREIGN KEY(pais_id)
                REFERENCES pais(id),

    CONSTRAINT fk_registros_status
                  FOREIGN KEY(status_id)
                    REFERENCES status(id)
);