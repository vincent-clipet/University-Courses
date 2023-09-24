
<?php

@session_start();
include 'include/php_start.php';



if (! isset($_SESSION['login']) || $_SESSION['login'] == "")
{
	echo "<html><head><meta http-equiv=\"Refresh\" content=\"3;URL=./index.php\"></head><body><div class=\"redirection\">";
	echo "Vous devez être connecté pour poster un nouvel article ! <br /> Retour à l'accueil ...";
	echo "</div></body></html>";
}

else
{
	?>
	<form method="post" action="./new_article_action.php">
	<fieldset>
		<legend>Nouvel article :</legend>
		<br /> Titre : <br />
		<input type="text" name="title" id="title" value="" /> <br />
		Contenu : <br />
		<textarea name="content" rows="10" cols="50" maxlength="64000">Tapez votre news ici</textarea>
		<br /> <input type="submit" name="soumission" id="soumission" />
	</fieldset>
	</form>
	<?php
}



?>
