DROP SCHEMA IF EXISTS projetIC5 CASCADE;

CREATE SCHEMA projetIC5;
SET SEARCH_PATH=projetIC5,PG_CATALOG;

CREATE TABLE member (
    id SERIAL PRIMARY KEY,
    name character varying(40) NOT NULL,
    birthdate date NOT NULL,
    genre character(1) CHECK (genre IN ('h','f')) NOT NULL,
	password character varying(40) NOT NULL
);

CREATE TABLE news (
    id SERIAL PRIMARY KEY,
    title character varying(100) NOT NULL,
    content character varying(64000) NOT NULL,
	newsdate date NOT NULL,
	idauthor integer NOT NULL REFERENCES member(id)
);

INSERT INTO member (name, birthdate, genre, password) VALUES ('Vincent',	'1992-12-07',		'h', 'progtr00');
INSERT INTO member (name, birthdate, genre, password) VALUES ('Admin',		'1999-12-07',		'h', 'progtr01');
INSERT INTO member (name, birthdate, genre, password) VALUES ('Invité',	'1991-04-25',		'h', 'progtr02');
INSERT INTO member (name, birthdate, genre, password) VALUES ('Invitée',	'1993-09-25',		'f', 'progtr03');

INSERT INTO news (title, content, newsdate, idauthor) VALUES ('Premiere news !','Voici la premiere news publiee sur ce site. De nouvelles news sont à venir !<br /><br /> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam nibh erat, hendrerit id aliquam sodales, eleifend eget risus. Suspendisse laoreet, leo ut mattis auctor, libero nisi tristique metus, ut varius libero elit ut orci. Integer vel interdum urna. Cras tellus ipsum, tempus at rutrum sed, porta ac est. Vivamus vel libero purus. Ut imperdiet venenatis dui at rutrum. Nunc placerat accumsan velit, quis gravida orci sollicitudin vitae. Vivamus molestie volutpat neque, sed adipiscing lacus fermentum at. Curabitur cursus, justo eu mollis condimentum, risus libero viverra enim, eu molestie nulla felis vitae metus. Ut odio nibh, feugiat non porttitor nec, ullamcorper vitae dui. Fusce elit quam, fringilla ac varius nec, vestibulum eu arcu. In et ipsum turpis. Duis lacus arcu, tincidunt in consectetur quis, adipiscing molestie nisl. Suspendisse sapien mi, placerat in varius quis, pharetra quis tellus. <br/>Praesent eget purus orci. Vivamus commodo, purus quis rutrum dignissim, sapien ante mollis dui, sit amet venenatis leo ante id metus. Morbi vitae ipsum felis, egestas cursus orci. Suspendisse potenti. Suspendisse viverra sagittis leo in malesuada. Etiam non mollis est. Nulla at arcu non ligula molestie consequat. Praesent lorem urna, adipiscing at lacinia viverra, congue eleifend elit. Etiam pulvinar velit non purus tempor fringilla eleifend urna elementum. Curabitur in odio semper mauris consequat laoreet non ac diam. Phasellus felis lectus, posuere vitae lacinia non, molestie et sem. Sed id ultrices augue. Nulla facilisi. Proin et nisi in risus venenatis porttitor. Donec rhoncus dictum dapibus.<br/>Quisque ut metus in est tempor pretium. Quisque eu iaculis odio. Nullam condimentum, elit eu interdum vestibulum, odio nulla tristique augue, eu adipiscing elit nibh non est. Vestibulum commodo tincidunt ante, et ultrices lacus feugiat ut. Maecenas vitae justo felis. Nunc semper vulputate enim, vel feugiat purus eleifend et. Donec risus eros, vehicula nec bibendum nec, ultrices ac magna. Nunc pretium lectus id enim dignissim rhoncus. Aenean at nisl magna, ac dictum lacus. Cras blandit urna sit amet leo rutrum vitae commodo quam pellentesque. Nunc eget sapien ante, non tempus erat. ','2013-03-20', 1);
INSERT INTO news (title, content, newsdate, idauthor) VALUES ('Et deuxieme news !','Voilà la deuxieme news publiee ! Pas grand chose de nouveau depuis la précédente ...<br /><br />Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?','2013-03-20', 2);
INSERT INTO news (title, content, newsdate, idauthor) VALUES ('Structure du site', '<p>Le site consiste en l ajout et la lecture d articles, postés par les utilisateurs.<br /><br />Chaque article possède un titre, un contenu, une date et ID de l utilisateur ayant posté l article.<br />Chaque utilisateur est défini par un pseudo, un mot de passe, une date de naissance et un sexe.<br /> <br />PS : L utilisateur doit être connecté pour pouvoir poster un article. Pour se connecter, utiliser le lien en haut à droite.</p> <br /><br /><br /><ul><li>index.php :</li>Page d accueil. Contient tous les articles postés; un lien vers la page de connexion; un lien vers le profil de l utilisateur actuellement connecté; et un lien vers la page permettant d ajouter un nouvel article.<li>profile.php :</li>Page affichant les infos de l utilisateur. Nécessite d être connecté.<li>new_article.php</li>Page permettant d ajouter un nouvel article au site. Nécessite d être connecté.<li>login.php</li>Page gérant la connexion / déconnexion d un utilisateur</ul><br /><br />Diagramme de classes :<br /><img src="./diagramme_classes.png"><br /><br />Schéma relationnel : <br /><img src="./schema_relationnel.png"><br /><br />','2013-03-21', 1);
