DROP TABLE IF EXISTS avion, pilote, ligne, vol;

-- avion
CREATE TABLE avion
(
	ano SERIAL,
	type TEXT,
	places INTEGER CHECK (places > 100 AND places < 500),
	compagnie TEXT,
	CONSTRAINT pk_avion PRIMARY KEY (ano)
);
	
-- pilote
CREATE TABLE pilote
(
	pno SERIAL,
	nom TEXT,
	prenom TEXT,
	adresse TEXT DEFAULT 'Lille',
	CONSTRAINT pk_pilote PRIMARY KEY (pno)
);

-- ligne
CREATE TABLE ligne
(
	lno SERIAL,
	depart TEXT,
	arrivee TEXT,
	CONSTRAINT pk_ligne PRIMARY KEY (lno)
);

-- vol
CREATE TABLE vol
(
	ano INTEGER,
	pno INTEGER,
	lno INTEGER,
	CONSTRAINT fk_ano FOREIGN KEY (ano)	REFERENCES avion(ano) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_pno FOREIGN KEY (pno) REFERENCES pilote(pno) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_lno FOREIGN KEY (lno) REFERENCES ligne(lno) ON DELETE RESTRICT ON UPDATE CASCADE,
	hdep TIME,
	harr TIME,
	CONSTRAINT pk_vol PRIMARY KEY (ano,pno,lno)
);



-- data
INSERT INTO avion(type, places, compagnie) VALUES ('A380', 480, 'Air France');
INSERT INTO avion(type, places, compagnie) VALUES ('A350', 356, 'KLM');
INSERT INTO avion(type, places, compagnie) VALUES ('B747', 470, 'RyanAir');
INSERT INTO pilote(nom, prenom, adresse) VALUES ('Random', 'Guy', 'Paris');
INSERT INTO pilote(nom, prenom) VALUES ('Jean', 'Dupont');
INSERT INTO pilote(nom, prenom, adresse) VALUES ('Toto', 'Dubois', 'Brest');
INSERT INTO ligne(depart, arrivee) VALUES ('Paris', 'Lyon');
INSERT INTO ligne(depart, arrivee) VALUES ('Marseille', 'Istanbul');
INSERT INTO ligne(depart, arrivee) VALUES ('Lille', 'Paris');
INSERT INTO vol(ano,pno,lno,hdep,harr) VALUES (1,2,3,'08:25:00', '09:14:00');
INSERT INTO vol(ano,pno,lno,hdep,harr) VALUES (3,3,2,'21:12:00', '01:01:00');
INSERT INTO vol(ano,pno,lno,hdep,harr) VALUES (2,2,1,'12:45:00', '15:45:00');






