<?php


// === SQL Utils =====================================

function getConnection()
{
	$conn = pg_connect(getDbLogin());

	if (! $conn) // Connection failed
	{
		$_SESSION['connection'] = null;
		return false;
	}
	else // Connection OK
	{
		$_SESSION['connection'] = $conn;
		pg_query($conn, "SET SEARCH_PATH=" . getPgSearchPath());
		return true;
	}
}

function connectDB($forceNewConnection)
{
	if (isset($_SESSION['connection']) && $_SESSION['connection'] != null && ! $forceNewConnection) // Already connected
		return true;
	else
		return getConnection(); // return true if connected; false if an error happened
}

function select($query)
{
	$results = pg_query($_SESSION['connection'], $query);
	return $results;
}

function update($query)
{
	$results = pg_query($_SESSION['connection'], $query);
	return pg_affected_rows($results);
}


function logIn($userName, $userPass, $userGenre, $userBirthDate, $userID)
{
	$_SESSION['login'] = $userName;
	$_SESSION['password'] = $userPass;
	$_SESSION['genre'] = $userGenre;
	$_SESSION['birthdate'] = $userBirthDate;
	$_SESSION['id'] = $userID;
}

function logOut()
{
	$_SESSION['login'] = "";
	$_SESSION['password'] = "";
	$_SESSION['genre'] = "";
	$_SESSION['birthdate'] = "";
	$_SESSION['id'] = "";
}




// === SQL Requests =====================================

function getAllNews()
{
	$req = "SELECT * FROM news ORDER BY id DESC;";
	$results = select($req);
	return $results;
}

function getUserById($userID)
{
	$req = "SELECT * FROM member M WHERE M.id = " . $userID . ";";
	$results = select($req);
	return $results;
}

function getUserByName($name)
{
	$req = "SELECT * FROM member M WHERE M.name = '" . $name . "';";
	$results = select($req);
	return $results;
}

function getUsername($userID)
{
	$req = "SELECT name FROM member M WHERE M.id = " . $userID . ";";
	$results = select($req);
	return pg_result($results, 0, 0);
}

function addArticle($title, $content, $authorID)
{
	$req = "INSERT INTO news (title, content, newsdate, idauthor)
			VALUES ('".$title."','".$content."','".getCurrentDate()."', ".$authorID.");";
	$results = update($req);
	return $results;
}







// === Misc =====================================

function getResultAsHTML($results)
{
	$rows = pg_num_rows($results);
	$cols = pg_num_fields($results);

	$ret = "<table border=\"1px black\">\n";

	for ($j = 0; $j < $rows; $j++)
	{
		$ret .= "<tr>\n";

		for ($i = 0; $i < $cols; $i++)
			$ret .= "<td>" . pg_result($results, $j, $i) . "</td>\n";

		$ret .= "</tr>\n";
	}

	$ret .= "</table>\n";
	return $ret;
}

function getCurrentDate()
{
	date_default_timezone_set('UTC');
	return date("y-m-d");
}

function hidePassword($pass)
{
	$length = strlen($pass);
	$toPrint = "";
	for ($i = 0; $i < $length; $i++)
		$toPrint .= "*";
	return $toPrint;
}


?>