<?php

// =======
// print_r

print_r($_POST);

// =======


echo "<br /><hr><br />";


// =======
// foreach

foreach ($_POST as $key => $value)
{
	if (is_array($value))
	{
		foreach ($value as $subkey => $subvalue)
			echo "$value[$subkey]" . "; ";

		echo "<br />";
	}
	else
		echo "$value" . "<br />";
}

// =======


echo "<br /><hr><br />";


// ==================
// Customized message

if (! (isset($_POST['sexe']) && isset($_POST['nom']) && isset($_POST['prenom']) && isset($_POST['newsletter'])))
	echo "Informations incomplètes, veuillez remplir à nouveau le formulaire.";
else
{
	if (isset($_POST['sports']))
		$number_sports = count($_POST['sports']);
	else
		$number_sports = 0;
	$message = "Bonjour " .
			(($_POST['sexe'] == "homme") ? "Mr. " : "Mme. ") .
			$_POST['nom'] . " " . $_POST['prenom'] . ". <br />" .
			(($_POST['newsletter'] == "news") ? "Vous avez accepté de recevoir notre newsletter." : "Vous ne désirez pas recevoir notre newsletter.") .
			"<br />";

	if ($number_sports == 0)
		$message .= "Vous ne pratiquez aucun sport.";
	else
	{
		if ($number_sports == 1)
		{
			$message .= "Sport pratiqué : ";
			$message .=  $_POST['sports'][0];
		}
		else
		{
			$message .= "Sports pratiqués : ";
			foreach ($_POST['sports'] as $index => $value)
			{
				if ($index == $number_sports - 1)
					$message .= " et ";
				else if ($index > 0)
					$message .= ", ";

				$message .= $value;
			}
		}

		$message .= ".";
	}

	echo $message;
}

// ==================

?>
















