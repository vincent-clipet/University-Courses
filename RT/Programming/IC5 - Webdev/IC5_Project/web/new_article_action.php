
<?php

@session_start();
include 'include/php_start.php';



$redirect = "";
$added = false;

if ($_POST['title'] == "")
{
	$redirect = "<div>Aucun titre spécifié !<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
}
else if (! isset($_POST['content']) || $_POST['content'] == "")
{
	$redirect = "<div>Contenu vide !<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
}
else
{
	$var = addArticle($_POST['title'], $_POST['content'], $_SESSION['id']);

	if ($var == 1)
	{
		$redirect = "<div>Article ajouté !<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
		$added = true;
	}
	else
		$redirect = "<div>Erreur inconnue lors de l'ajout dans la base de données.<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
}




if ($redirect != "")
{
	if (! $added)
	{
		echo "<html><head><meta http-equiv=\"Refresh\" content=\"3;URL=./new_article.php\"></head><body><div class=\"redirection\">";
		echo $redirect;
		echo "</div></body></html>";
	}
	else 
	{
		echo "<html><head><meta http-equiv=\"Refresh\" content=\"3;URL=./index.php\"></head><body><div class=\"redirection\">";
		echo $redirect;
		echo "</div></body></html>";
	}
}



?>
