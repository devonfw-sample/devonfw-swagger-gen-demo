CREATE TABLE STAFFMEMBER(
    id BIGINT NOT NULL,
    modificationCounter INTEGER NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    login VARCHAR(255)
);

insert into staffmember(id, modificationCounter, firstname, lastname, login)
values('1', 1, 'Roger', 'Shane', 'roger.shanecapgemini.com');