DROP SCHEMA IF EXISTS caddie CASCADE;

CREATE SCHEMA caddie;
SET SEARCH_PATH=caddie,PG_CATALOG;

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    nom character varying(30) NOT NULL,
    prenom character varying(30),
    datenaissance date,
    sexe character(1) CHECK (sexe IN ('h','f'))
);

CREATE TABLE article (
    id SERIAL PRIMARY KEY,
    libelle character varying(100) NOT NULL,
    prix real
);

CREATE TABLE achat (
    id SERIAL PRIMARY KEY,
    dateachat date,
    quantite integer,
    idarticle integer NOT NULL REFERENCES article(id),
    idclient integer NOT NULL REFERENCES client(id)
);

INSERT INTO article (libelle, prix) VALUES ('voiture type A',	5.1999998);
INSERT INTO article (libelle, prix) VALUES ('voiture type B',	10.2);
INSERT INTO article (libelle, prix) VALUES ('Solex type A',4.0999999);
INSERT INTO article (libelle, prix) VALUES ('Solex type GB',12.2);

INSERT INTO client (nom, prenom, datenaissance, sexe) VALUES ('Nestor','René','1929-08-10','h');
INSERT INTO client (nom, prenom, datenaissance, sexe) VALUES ('Jacques','Irma','1963-06-09','f');
INSERT INTO client (nom, prenom, datenaissance, sexe) VALUES ('Dupont','Henri','1954-11-11','h');
INSERT INTO client (nom, prenom, datenaissance, sexe) VALUES ('Dupont','Josette','1922-01-20','f');
INSERT INTO client (nom, prenom, datenaissance, sexe) VALUES ('Nesta','Jacques','1975-05-13','h');
INSERT INTO client (nom, prenom, datenaissance, sexe) VALUES ('Maradona','Diego','1960-10-30','h');

INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-03',8,1,1);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-03',2,1,1);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-10',4,4,4);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-11',10,1,5);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-13',10,2,1);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-13',8,2,1);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-14',1,1,1);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-16',2,1,2);
INSERT INTO achat (dateachat, quantite, idarticle, idclient) VALUES ('2009-02-18',2,1,3);

