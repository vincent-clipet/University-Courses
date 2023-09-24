Auteur : P Mathieu
Date   : 28/12/2002

				SQUELETTE
				=========

Squelette d'une webapp utilisant des paramètres externes, une
errorPage, une CSS, un Realm et un Pool.

Ce squelette a été réalisé pour permettre le développement rapide
d'une application necessisant une authentification et montrer des
exemples de paramétrage des fichiers server.xml et web.xml.

Pour mettre en oeuvre cet exemple il faut tout d'abord creer la base
et les tables nécessaires. Ensuite, il faut définir le contexte
(vide_evolue.xml à destination de server.xml), Vérifier/corriger dans
ce fichier les références physiques à la BDD. Le web.xml est déjà pret
à l'usage, il n'y a a priori rien à toucher dedans, jetez y quand même
un coup d'oeil rapide.

------------------------------
I) Construction

page1 : permet de voir si les JSP classiques fonctionnent. Cette page
ne fait rien de particulier

page 2, page 3 : permet de tester le realm. Selon que vous soyez Paul
ou Pierre, vous ne pouvez accéder qu'à l'une des deux.

page 4 : montre comment accéder directement à une BDD

page5 : montre comment accéder à la BDD via un Pool et montre aussi
comment utiliser un Bean.


------------------------------
I) Création de la base

Le Realm utilise l'interface JDBCRealm. Il faut tout d'abord creer une
base nommée vide_evolue qui est accessible à l'utilisateur "mathieu"
avec le mot de passe "philippe". Ensuite les (login,role,mdp) sont
stockes dans les tables suivantes :

create table users
(
user_name text,
user_pass text
);

create table user_roles
(
user_name text,
role_name text
);

insert into users values('pierre','pierre');
insert into users values('paul','paul');
insert into user_roles values('pierre','role1');
insert into user_roles values('paul','role2');

On pourrait éventuellement mettre tout ceci dans une seule table. Il
faudrait alors modifier les définitions du Realm dans vide_evolue.xml.

Ne pas oublier de mettre le driver postgresql.jar dans le repertoire
common/lib de tomcat.

Ne pas oublier non plus de compiler les Beans qui se trouvent dans
WEB-INF/classes/tools

Ne pas mettre d'accent dans les commentaires des fichiers XML ! ça
crée un plantage de Tomcat


------------------------------
II) Définition du contexte

La définition du contexte se trouve dans le fichier META-INF/context.xml

version < 5.0 : recopier le contenu dans server.xml à l'endroit adéquat

version < 5.5 : recopier ce fichier dans conf/Catalina/localhost avec
comme nom videEvolue.xml

version supérieures : ne rien à faire !


Il faut ensuite bien vérifier dans ce fichier que toute référence
physique externe est bien paramétrée. C'est notamment le cas des
références à la BDD dans le Pool et dans le Realm.


------------------------------
III) Gestion de la sécurité (déjà présent, rien à faire).

<!-- Définition des paramètres du Realm dans le web.xml -->

    <!--  lien entre les pages et les roles -->
    <security-constraint>
     <web-resource-collection>
       <web-resource-name>Administrateur</web-resource-name>
         <url-pattern>/page2.html</url-pattern>
     </web-resource-collection>
      <auth-constraint>
         <role-name>role1</role-name>
      </auth-constraint>
    </security-constraint>

    <security-constraint>
     <web-resource-collection>
       <web-resource-name>Administrateur</web-resource-name>
         <url-pattern>/page3.html</url-pattern>
     </web-resource-collection>
      <auth-constraint>
         <role-name>role2</role-name>
      </auth-constraint>
    </security-constraint>

    <security-constraint>
     <web-resource-collection>
       <web-resource-name>Administrateur</web-resource-name>
         <url-pattern>/page4.jsp</url-pattern>
     </web-resource-collection>
      <auth-constraint>
         <role-name>role1</role-name>
         <role-name>role2</role-name>
      </auth-constraint>
    </security-constraint>


    <!-- la maniere dont la page de login est affichee -->
    <login-config>
      <auth-method>BASIC</auth-method>
      <realm-name>Nom affiché sur le formulaire</realm-name>
    </login-config>

    <!-- la liste des differents roles -->
    <security-role>
      <role-name>role1</role-name>
    </security-role>
    <security-role>
      <role-name>role2</role-name>
    </security-role> 


------------------------------
IV) La page4

    la page4 montre comment on accède à la base de données
    directement. Il y a donc dedans une référence physique à la
    BDD. Vérifiez qu'elle est correcte pour que la page fonctionne.

------------------------------
V) La page5

    la page5 utilise le pool de connexion et un Bean pour afficher la
    table avec des méthodes statiques. Il n'y a plus de référence
    physique à la base et il n'y a quasiment plus de code pour
    afficher la table. Cette forme d'écriture est à préférer ;-)





    