<?php

include './config.php.inc';
include './utils.php.inc';



if (! connectDB(false))
{
	echo "<br /> <br /> <hr /> <br />";
	echo ("<h3>Erreur ! V�rifiez les informations de connexion � la base de donn�es (Dans le fichier 'config.php.inc')</h3>");
	exit;
}

?>