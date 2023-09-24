<?php
 
function getDbLogin()
{
	return "host=localhost port=5432 dbname=postgres user=postgres password=progtr00";
}

function getPgSearchPath()
{
	return "projetIC5,PG_CATALOG";
}

?>