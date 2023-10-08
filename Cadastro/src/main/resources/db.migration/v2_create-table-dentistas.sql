
CREATE TABLE dentistas (

    funcionario_cpf VARCHAR(11) PRIMARY KEY,
    cro VARCHAR(11) NOT NULL UNIQUE,
    especializacao VARCHAR(100) NOT NULL,

    FOREIGN KEY (funcionario_cpf) REFERENCES funcionarios (cpf)

    ON DELETE CASCADE
    ON UPDATE CASCADE
);



