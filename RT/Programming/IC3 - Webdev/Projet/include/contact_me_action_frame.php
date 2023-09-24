<div class="content">
	<div id="contact_me_action">

		<?php 

		if (! (isset($_POST['sexe']) && isset($_POST['nom']) && isset($_POST['prenom']) && isset($_POST['objet'])))
			echo "Informations incomplètes, veuillez remplir à nouveau le formulaire.";
		else
		{
			$number_sports = 0;
			$message = "Merci " .
					(($_POST['sexe'] == "homme") ? "Mr. " : "Mme. ") .
					$_POST['prenom'] . " " . $_POST['nom'] . ". <br />";
			$message .= "Votre message <span id=\"objet\">\"" . $_POST['objet'] ."\"</span> a bien été envoyé.";

			echo $message;
			
			echo "<br /><br /><a href=\"./main.php\">Retour à l'accueil</a>";
		}

		?>

	</div>
</div>
