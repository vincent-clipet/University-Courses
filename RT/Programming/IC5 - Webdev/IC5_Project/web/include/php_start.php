<?php

include './config.php.inc';
include './utils.php.inc';



if (! connectDB(false))
{
	echo "<br /> <br /> <hr /> <br />";
	echo ("<h3>Erreur ! Vérifiez les informations de connexion à la base de données (Dans le fichier 'config.php.inc')</h3>");
	exit;
}

?>