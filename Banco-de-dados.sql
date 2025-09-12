-- Tabela Locadora
CREATE TABLE Locadora (
    id_locadora INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(30)
) ENGINE=InnoDB;

-- Tabela Categoria
CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

-- Tabela Cliente
CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE, -- formato: '000.000.000-00'
    telefone VARCHAR(30)
) ENGINE=InnoDB;

-- Tabela Filme
CREATE TABLE Filme (
    id_filme INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    quantidade INT NOT NULL DEFAULT 1 CHECK (quantidade >= 0),
    id_categoria INT NOT NULL,
    id_locadora INT NOT NULL,
    CONSTRAINT fk_filme_categoria FOREIGN KEY (id_categoria)
        REFERENCES Categoria(id_categoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_filme_locadora FOREIGN KEY (id_locadora)
        REFERENCES Locadora(id_locadora)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

-- Tabela Locacao (cada locacao refere 1 cliente, 1 locadora e 1 filme)
CREATE TABLE Locacao (
    id_locacao INT AUTO_INCREMENT PRIMARY KEY,
    data_locacao DATE NOT NULL,
    data_devolucao DATE,
    id_cliente INT NOT NULL,
    id_locadora INT NOT NULL,
    id_filme INT NOT NULL,
    CONSTRAINT fk_locacao_cliente FOREIGN KEY (id_cliente)
        REFERENCES Cliente(id_cliente)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_locacao_locadora FOREIGN KEY (id_locadora)
        REFERENCES Locadora(id_locadora)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_locacao_filme FOREIGN KEY (id_filme)
        REFERENCES Filme(id_filme)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;
