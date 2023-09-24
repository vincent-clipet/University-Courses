DROP TABLE IF EXISTS fournisseurs, produits, commandes;

-- fournisseurs
CREATE TABLE fournisseurs
(
	fno INTEGER,
	nom TEXT,
	--places INTEGER CHECK (places > 100 AND places < 500),
	ville TEXT,
	CONSTRAINT pk_fournisseurs PRIMARY KEY (fno)
);
	
-- produits
CREATE TABLE produits
(
	pno INTEGER,
	libelle TEXT,
	prix INTEGER,
	--adresse TEXT DEFAULT 'Lille',
	CONSTRAINT pk_produits PRIMARY KEY (pno)
);

-- commandes
CREATE TABLE commandes
(
	cno INTEGER,
	fno INTEGER,
	pno INTEGER,
	qtt INTEGER,
	CONSTRAINT fk_fno FOREIGN KEY (fno)	REFERENCES fournisseurs(fno) ON DELETE SET NULL,
	CONSTRAINT fk_pno FOREIGN KEY (pno) REFERENCES produits(pno) ON DELETE RESTRICT,
	CONSTRAINT pk_commandes PRIMARY KEY (cno)
);




-- data
--INSERT INTO fournisseurs(id, nom, ville) VALUES ('', '');








