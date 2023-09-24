<?php
@session_start();
include 'include/php_start.php';



// === Page ===

if (! isset($_SESSION['login']) || $_SESSION['login'] == "")
{
	echo "<html><head><meta http-equiv=\"Refresh\" content=\"3;URL=./index.php\"></head><body><div class=\"redirection\">";
	echo "Vous devez être connecté pour consulter votre profil ! <br /> Retour à l'accueil ...";
	echo "</div></body></html>";
}

else
{
	echo "<div>";
	echo "Pseudo : " . $_SESSION['login'] . "<br />";
	echo "Date de naissance : " . $_SESSION['birthdate'] . "<br />";
	echo "Sexe : " . $_SESSION['genre'] . "<br />";
	echo "Password : " . hidePassword($_SESSION['password']) . "<br />";
	echo "</hr>";
	echo "<a href=\"./index.php\">Retour à l'accueil</a>";
	echo "</div>";
}



?>