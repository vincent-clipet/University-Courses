<?php

// Hello World
echo "Bonjour !";
echo "<hr>";


// Static date
@setlocale('LC_TIME', 'fr_FR.utf8','fra');
echo "
		<br />
		Au moment de l'ex�cution de ce script PHP, nous sommes le " . strftime('%A %d %B %Y');
echo "
		<br />
		Il est actuellement " . strftime("%H %M %S") . "<hr>";;


// Dynamic date
$h = strftime("%H");
echo "<br />";

if ($h >= 6 && $h < 13)
	echo "Bonne journ�e !";
else if ($h >= 13 && $h < 18)
	echo "Bon apr�s-midi !";
else if ($h >= 18 && $h < 21)
	echo "Bonne soir�e !";
else if ($h >= 21 && $h < 6)
	echo "Bonne nuit !";

echo "<hr>";


// $_SERVER
echo "<br />";

print_r($_SERVER);


?>