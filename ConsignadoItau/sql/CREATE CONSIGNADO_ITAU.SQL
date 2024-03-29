CREATE SCHEMA CONSIGNADO_ITAU;
CREATE TABLE CLIENTE_AUTORIZADO_CONSIGNADO
(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	CPF_CLIENTE VARCHAR(11) NOT NULL,
    NOME_CLIENTE VARCHAR(255) NOT NULL,
    DATA_NASCIMENTO_CLIENTE DATE NOT NULL,
    MARGEM_BENEFICIO_CONTRATACAO INT NOT NULL,
    NUMERO_BENEFICIO LONG NOT NULL,
    DATA_AUTORIZACAO_CONSULTA DATE,
    DATA_DESPACHO_BENEFICIO DATE NOT NULL,
    FLAG_AUTORIZACAO_CLIENTE BOOLEAN NOT NULL
);
CREATE INDEX CLIENTE_AUTORIZADO_CPF ON CLIENTE_AUTORIZADO_CONSIGNADO (CPF_CLIENTE) ;

CREATE TABLE CLIENTE_CONSIGNADO_CONTRATO
(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	CPF_CLIENTE VARCHAR(11) NOT NULL,
    QUANTIDADE_PARCELAS INT NOT NULL,
    VENCIMENTO_PARCELA INT NOT NULL,
    DATA_INICIO_CONTRATO DATE NOT NULL,
    DATA_ENCERRAMENTO_CONTRATO DATE NOT NULL,
    NUMERO_BENEFICIO LONG NOT NULL   
);
CREATE INDEX CLIENTE_CONTRATO_CPF ON CLIENTE_CONSIGNADO_CONTRATO (CPF_CLIENTE) ;
