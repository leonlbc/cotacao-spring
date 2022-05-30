
CREATE TABLE espm.moeda (
	id_moeda varchar(40) not null,
    tx_nome varchar(50) not null,
    tx_simbolo varchar(5) not null,
    primary key pk_moeda (id_moeda)
);

CREATE TABLE espm.cotacao(
    id_cotacao varchar(64) not null,
    id_moeda varchar(64) not null,
    dt_data date not null,
    vr_valor decimal(14,4),
    primary key pk_cotacao (id_cotacao)
);
