
<?php

@session_start();
include 'include/php_start.php';



$redirect = "";
$added = false;

if ($_POST['title'] == "")
{
	$redirect = "<div>Aucun titre sp�cifi� !<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
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
		$redirect = "<div>Article ajout� !<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
		$added = true;
	}
	else
		$redirect = "<div>Erreur inconnue lors de l'ajout dans la base de donn�es.<br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
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
