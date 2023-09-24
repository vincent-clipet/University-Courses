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

function connectDB()
{
	if (isset($_SESSION['connection']) && $_SESSION['connection'] != null && $_SESSION['connection'] != "")
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

		// Sch�ma
		pg_query($conn, "SET SEARCH_PATH=film,PG_CATALOG");
		return true;
	}
}




if (! connectDB())
	exit;



// Liste des genres
echo "<h3>Genres</h3>";
printResults("SELECT * FROM genrefilm");

// Liste des films
echo "<h3>Films</h3>";
printResults("SELECT F.id, F.titre, F.anneesortie, R.nom, R.prenom
		FROM film F, realisateur R
		WHERE F.idrealisateur = R.id");

// D�connexion
// pg_close($conn);




?>