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
<form method="post" action="addGenre2.php">
	<fieldset>
		<legend>Ajout d'un genre</legend>

			<label for="genre">Genre : </label>
			<input type="text" name="genre" id="genre" value="" />

		</select> <input type="submit" name="ajouter" id="ajouter"
			value="ajouter" />
	</fieldset>
</form>
