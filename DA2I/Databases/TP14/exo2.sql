BEGIN;
INSERT INTO compte VALUES('duchemin', 40);
SELECT * FROM compte;
INSERT INTO compte VALUES('durand', 'paul');
COMMIT;

SELECT * FROM compte;
