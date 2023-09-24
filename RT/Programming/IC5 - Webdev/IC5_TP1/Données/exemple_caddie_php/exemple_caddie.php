<?php
@session_start();
?>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title> Exemple simple, schéma caddie </title>
<link rel="stylesheet" type="text/css" href ="caddie.css"/>
</head>

<body>
<?php

$conn = pg_connect("host=localhost dbname=postgres user=postgres password=PO0STGRE3S");

if(!$conn){
    echo "<p>Connexion à la base impossible.</p>\n";
    exit;
}else{
    echo "<p>Connexion à la base réussie.</p>\n";
}

pg_query($conn, "SET SEARCH_PATH=caddie,PG_CATALOG");

$result = pg_query($conn, "SELECT *,extract(year from age(datenaissance)) AS age, age(datenaissance) AS \"age precis\" FROM client");

$nombreLignes = pg_num_rows($result);
$nombreColonnes = pg_num_fields($result);

?>

<!-- Méthode n°1 -->
<table>
<caption> Liste des clients (Méthode n°1) </caption>
<?php
for($i = 0; $i < $nombreLignes; $i++){
    echo "<tr>";
    for($j = 0; $j < $nombreColonnes; $j++)
        echo "<td>".pg_result($result, $i, $j)."</td>";
    echo "</tr>\n";
}
?>
</table>

<!-- Méthode n°2 -->
<table>
<caption> Liste des clients (Méthode n°2) </caption>
<?php
while($ligne = pg_fetch_array($result)){
    echo "<tr>";
    for($i = 0; $i < $nombreColonnes; $i++)
        echo "<td>".$ligne[$i]."</td>";
    echo "</tr>\n";
}
?>
</table>

<?php

pg_close($conn);

if(isset($_SESSION['err']) && $_SESSION['err']!="")
    echo "<div id=\"erreur\"> <p>Erreur : ".$_SESSION['err']."</p></div>";

if(isset($_SESSION['msgN']) && $_SESSION['msgN']!="")
    echo "<div id=\"notification\"> <p>".$_SESSION['msgN']."</p></div>";
?>

<form method="post" action="exemple_caddie_action.php">
     <fieldset>
          <legend>Ajout d'un nouveau client</legend>
          <label for="nom">Nom</label> :
          <input type="text"  name="nom" id="nom" value="<?php if(isset($_SESSION['nom'])) echo $_SESSION['nom'];?>" />
          <label for="prenom">Prénom</label> :
          <input type="text"  name="prenom" id="prenom" value="<?php if(isset($_SESSION['prenom'])) echo $_SESSION['prenom'];?>"/>
          <input type="radio" name="sexe" id="sexe" value="h"
             <?php if(isset($_SESSION['sexe']) && $_SESSION['sexe']=="h") echo " checked=\"checked\"";?> />
          <label for="homme">Homme</label>
          <input type="radio" name="sexe" id="sexe" value="f"
             <?php if(isset($_SESSION['sexe']) && $_SESSION['sexe']=="f") echo " checked=\"checked\"";?> />
          <label for="femme">Femme</label>
          <hr/>
          <label for="datenaissance">Naissance : année </label> <select name="annee" id="anneee">
    	  <?php 
          for ($i=date('Y');$i>=1850;$i--){
                echo "<option value=\"$i\"";
                if($_SESSION['annee']==$i) echo "selected=\"selected\"";
    		echo "> $i";
          }?>
    	  </select>
          <label for="mois">mois </label> <select name="mois" id="mois">
          <?php for ($i=1;$i<=12;$i++){
                echo "<option value=\"$i\"";
                if($_SESSION['mois']==$i) echo "selected=\"selected\"";
    		echo "> $i";
          }?>
    	  </select>
          <label for="jour">jour </label> <select name="jour" id="jour">
    	  <?php for ($i=1;$i<=31;$i++){
                echo "<option value=\"$i\"";
                if($_SESSION['jour']==$i) echo "selected=\"selected\"";
    		echo "> $i";
          }?>
    	  </select>
          <input type="submit" name="ajoutclient" id="ajoutclient" value="Ajout Client"/>
     </fieldset>
</form>

</body>
</html>