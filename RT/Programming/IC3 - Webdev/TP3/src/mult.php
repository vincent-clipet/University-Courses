
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Exercice 2</title>
</head>
<body>


	<table
		style="border: 1px solid red; text-align: center; width: 40%; margin: 10px auto;">

		<caption style="color: red; text-align: center">Table de Multiplication</caption>

		<?php
		for ($i = 1; $i <= 10; $i++)
		{
			echo "<tr style=\"text-align: right;\">";
			
			for ($j = 1; $j <= 10; $j++)
				echo "<td>" . ($j * $i) . "</td>";
			
			echo "</tr>\n";
		}
		?>

	</table>

</body>
</html>
