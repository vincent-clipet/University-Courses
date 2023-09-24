<?php
@session_start();
include 'include/php_start.php';

// === Functions ===

function printNews($results, $row)
{
	$title = pg_result($results, $row, 1);
	$content = pg_result($results, $row, 2);
	$date = pg_result($results, $row, 3);
	$authorID = pg_result($results, $row, 4);
	
	echo "<div class=\"news\">";

	echo "<p class=\"news_infos\">";
	echo "Posté par <span class=\"author\">" . getUsername($authorID) . "</span> le <span class=\"date\">" . $date . "</span>";
	echo "</p>";
	
	echo "<h3>" . $title . "</h3>";

	
	echo "<p class=\"news_content\">";
	echo "" . $content;
	echo "</p>";
	
	echo "</div>";
}

function printLoggedIn()
{
	echo "<div class=\"login\">";
	
	if ($_SESSION['login'] != "") // Logged in
	{
		echo "<form method=\"post\" action=\"login.php\">";
		echo "Connecté en tant que : <span id=\"username\"> " . $_SESSION['login'] . " <br />";
		echo "<input type=\"hidden\" name=\"action\" value=\"disconnect\" />";
		echo "<input type=\"submit\" name=\"confirm\" id=\"confirm\" value=\"Se déconnecter\" />";
		echo "</form>"; 
	}
	else // Not logged in
	{
		echo "<form method=\"post\" action=\"login.php\">";
		echo "Vous n'êtes pas connecté.<br />";
		echo "<input type=\"hidden\" name=\"action\" value=\"connect\" />";
		echo "<input type=\"submit\" name=\"confirm\" id=\"confirm\" value=\"Se connecter\" />";
		echo "</form>";
	}
	
	echo "</div>";
}





// === Page ===

include 'include/header.php';
printLoggedIn();
include 'include/tabs.php';



$news = getAllNews();

for ($iter = 0; $iter < pg_num_rows($news); $iter++)
{
	printNews($news, $iter);
}




include 'include/footer.php';


?>