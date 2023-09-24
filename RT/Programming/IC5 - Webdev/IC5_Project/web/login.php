	<?php
	
	@session_start();
	include 'include/php_start.php';
	
	
	// DEBUG
	//echo "====================== <br />";
	//if (isset($_POST['action'])) echo $_POST['action'] . " : action<br />";
	//if (isset($_POST['check']))echo $_POST['check'] . " : check<br />";
	//if (isset($_POST['user']))echo $_POST['user'] . " : user<br />";
	//if (isset($_POST['password']))echo $_POST['password'] . " : password<br />";
	//echo "====================== <br />";
	
	

	$redirect = "";

	// Perform connection/disconnection
	if (isset($_POST['check']))
	{
			
		// Check user/password
		if ( $_POST['check'] == "false")
		{
			$userFromDb = getUserByName($_POST['user']);
			$rows = pg_num_rows($userFromDb);

			if ($rows == 0) // User doesn't exist
			{
				$redirect = "<div>Nom d'utilisateur incorrect. <br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
			}
			else 
			{
				$var = pg_result($userFromDb, 0, 4);
			
				if ($var == $_POST['password']) // Password OK
				{
					logIn(
					pg_result($userFromDb, 0, 1),
					pg_result($userFromDb, 0, 4),
					pg_result($userFromDb, 0, 3),
					pg_result($userFromDb, 0, 2),
					pg_result($userFromDb, 0, 0)
					);
	
					$redirect = "Vous êtes maintenant connecté. <br /> <a href=\"./index.php\"> Redirection en cours ...";
				}
				else // Invalid password
				{
					$redirect = "<div>Mot de passe incorrect. <br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
				}
			}
		}
			
		// Disconnection OK
		else if ( $_POST['check'] == "true")
		{
			logOut();
			$redirect = "<div>Vous êtes maintenant déconnecté. <br /> <a href=\"./index.php\"> Redirection en cours ... </a>";
		}
	}



	// Perform redirection
	if ($redirect != "")
	{
		echo "<html><head><meta http-equiv=\"Refresh\" content=\"3;URL=./index.php\"></head><body><div class=\"redirection\">";
		echo $redirect;
		echo "</div></body></html>";
	}


	// Ask user/password
	else
	{
		// Form Disconnect
		if (isset($_POST['action']) && $_POST['action'] == "disconnect")
		{
			?>
			<form method="post" action="./login.php">
				<fieldset>
					<legend>Se déconnecter</legend>
					<input type="hidden" name="check" value="true" />
					<br /> <input type="submit" name="soumission" id="soumission" />
				</fieldset>
			</form>
			<?php
		}

		// Form Connect
		else if (isset($_POST['action']) && $_POST['action'] == "connect")
		{
			?>
			<form method="post" action="./login.php">
				<fieldset>
					<legend>Se connecter</legend>
					<br /> User : <input type="text" name="user" id="user" value="" /> <br />
					Pass : <input type="password" name="password" id="password" value="" />
					<br /> <input type="submit" name="soumission" id="soumission" />
					<input type="hidden" name="check" value="false" />
				</fieldset>
			</form>
			<?php
		}
	}

	?>
