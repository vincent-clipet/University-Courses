Auteur : P Mathieu
Date   : 28/12/2002

				SQUELETTE
				=========

Squelette d'une webapp utilisant des param�tres externes, une
errorPage, une CSS, un Realm et un Pool.

Ce squelette a �t� r�alis� pour permettre le d�veloppement rapide
d'une application necessisant une authentification et montrer des
exemples de param�trage des fichiers server.xml et web.xml.

Pour mettre en oeuvre cet exemple il faut tout d'abord creer la base
et les tables n�cessaires. Ensuite, il faut d�finir le contexte
(vide_evolue.xml � destination de server.xml), V�rifier/corriger dans
ce fichier les r�f�rences physiques � la BDD. Le web.xml est d�j� pret
� l'usage, il n'y a a priori rien � toucher dedans, jetez y quand m�me
un coup d'oeil rapide.

------------------------------
I) Construction

page1 : permet de voir si les JSP classiques fonctionnent. Cette page
ne fait rien de particulier

page 2, page 3 : permet de tester le realm. Selon que vous soyez Paul
ou Pierre, vous ne pouvez acc�der qu'� l'une des deux.

page 4 : montre comment acc�der directement � une BDD

page5 : montre comment acc�der � la BDD via un Pool et montre aussi
comment utiliser un Bean.


------------------------------
I) Cr�ation de la base

Le Realm utilise l'interface JDBCRealm. Il faut tout d'abord creer une
base nomm�e vide_evolue qui est accessible � l'utilisateur "mathieu"
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

On pourrait �ventuellement mettre tout ceci dans une seule table. Il
faudrait alors modifier les d�finitions du Realm dans vide_evolue.xml.

Ne pas oublier de mettre le driver postgresql.jar dans le repertoire
common/lib de tomcat.

Ne pas oublier non plus de compiler les Beans qui se trouvent dans
WEB-INF/classes/tools

Ne pas mettre d'accent dans les commentaires des fichiers XML ! �a
cr�e un plantage de Tomcat


------------------------------
II) D�finition du contexte

La d�finition du contexte se trouve dans le fichier META-INF/context.xml

version < 5.0 : recopier le contenu dans server.xml � l'endroit ad�quat

version < 5.5 : recopier ce fichier dans conf/Catalina/localhost avec
comme nom videEvolue.xml

version sup�rieures : ne rien � faire !


Il faut ensuite bien v�rifier dans ce fichier que toute r�f�rence
physique externe est bien param�tr�e. C'est notamment le cas des
r�f�rences � la BDD dans le Pool et dans le Realm.


------------------------------
III) Gestion de la s�curit� (d�j� pr�sent, rien � faire).

<!-- D�finition des param�tres du Realm dans le web.xml -->

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
      <realm-name>Nom affich� sur le formulaire</realm-name>
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

    la page4 montre comment on acc�de � la base de donn�es
    directement. Il y a donc dedans une r�f�rence physique � la
    BDD. V�rifiez qu'elle est correcte pour que la page fonctionne.

------------------------------
V) La page5

    la page5 utilise le pool de connexion et un Bean pour afficher la
    table avec des m�thodes statiques. Il n'y a plus de r�f�rence
    physique � la base et il n'y a quasiment plus de code pour
    afficher la table. Cette forme d'�criture est � pr�f�rer ;-)





    