<?php
@session_start();



function printResults($query)
{
	echo "<br />";

	$result = pg_query($_SESSION['connection'], $query);
	$answers = pg_num_fields($result);

	echo "<table>";
	while($ligne = pg_fetch_array($result))
	{
		echo "<tr>";

		for($i = 0; $i < $answers; $i++)
			echo "<td>".$ligne[$i]."</td>";

		echo "</tr>\n";
	}

	echo "</table>";
	echo "<br /><br /><hr />";
}

function connectDB($forceNewConnection)
{
	if (isset($_SESSION['connection']) && $_SESSION['connection'] != null && $_SESSION['connection'] != "" && !$forceNewConnection)
		return true;
	else
	{
		// Connexion
		$conn = pg_connect("host=localhost port=5432 dbname=postgres user=postgres password=progtr00");
		/*$conn = pg_connect(
		 "host=".$host.
				" port=".$port.
				" dbname=".$dbname.
				" user=".$user.
				" password=".$passwd);*/

		if (! $conn)
		{
			echo "<p>Erreur connexion !</p>\n";
			$_SESSION['connection'] = "";
			return false;
		}
		else
			$_SESSION['connection'] = $conn;

		// Schéma
		pg_query($conn, "SET SEARCH_PATH=film,PG_CATALOG");
		return true;
	}
}

if (! connectDB(true))
	exit;



?>

<?php

$query = "SELECT genre
		FROM genre
		WHERE genre = '".$_POST['genre']."' LIMIT 1;";
$result = pg_query($_SESSION['connection'], $query);
$answers = pg_num_rows($result);

echo $answers;
echo "<br />";
echo $_POST['genre'];
echo "<br />";

if ($answers >= 1)
	echo "Ce genre existe déjà !";
else
{
	$query = "INSERT INTO genre (genre) VALUES ('".$_POST['genre']."')";
	$result = pg_query($_SESSION['connection'], $query);
	echo "Genre ".$_POST['genre']." ajouté !";
}

?>
