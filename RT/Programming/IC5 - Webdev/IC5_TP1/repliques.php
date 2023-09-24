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
<form method="post" action="repliques.php">
	<fieldset>
		<legend>Recherche de répliques</legend>

		<label for="film">Film : </label><select name="film" id="film">

			<?php 
			$query = "SELECT titre FROM film";
			$result = pg_query($_SESSION['connection'], $query);
			$answers = pg_num_fields($result);

			while ($ligne = pg_fetch_array($result))
			{
				for ($i = 0; $i < $answers; $i++)
					echo "<option value=\"".$ligne[$i]."\">".$ligne[$i]."</option>";
					
				echo "</tr>\n";
			}
			?>

		</select> <input type="submit" name="search" id="search"
			value="Chercher" />
	</fieldset>
</form>
<?php
if (isset($_POST['film']))
{
	$query = "SELECT RE.replique
		FROM repliquescultes RE, film F
		WHERE RE.idfilm = F.id AND F.titre = '".$_POST['film']."'";
	$result = pg_query($_SESSION['connection'], $query);
	$answers = pg_num_fields($result);



	echo "<table>\n";

	while ($ligne = pg_fetch_array($result))
	{
		for ($i = 0; $i < $answers; $i++)
			echo "<tr>".$ligne[$i]."</tr><br />\n";
	}

	echo "</table>";
}
?>
