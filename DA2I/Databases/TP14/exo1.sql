BEGIN transaction;
INSERT INTO compte VALUES('dupont', 100);
SELECT * FROM compte;
--ROLLBACK;
COMMIT;

SELECT * FROM compte;
