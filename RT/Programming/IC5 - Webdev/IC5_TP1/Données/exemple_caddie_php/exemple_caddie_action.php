<?php
@session_start();
/* Traitement de la page : ajout d'un client */
/* 1.Récupération des informations issues du formulaire */

$err="";

$nom=$_POST['nom'];
if($nom=="") $err="Veuillez préciser votre nom";
$prenom=$_POST['prenom'];
if($prenom=="") $err="Veuillez préciser votre prénom";
$annee=$_POST['annee'];
$mois=$_POST['mois'];
$jour=$_POST['jour'];
$sexe=$_POST['sexe'];
if(!isset($_POST['sexe'])) $err="Êtes vous un homme ou une femme ?";

/* 2.Stockage des informations dans la session */

$_SESSION['nom']=$_POST['nom'];
$_SESSION['prenom']=$_POST['prenom'];
$_SESSION['annee']=$_POST['annee'];
$_SESSION['mois']=$_POST['mois'];
$_SESSION['jour']=$_POST['jour'];
$_SESSION['sexe']=$_POST['sexe'];
$_SESSION['err']=$err;

/* 3.Renvoie vers les pages adéquates */

if($err==""){
    $sql="INSERT INTO client (nom,prenom,datenaissance,sexe) VALUES ";
    $sql.="('$nom','$prenom','$annee-$mois-$jour','$sexe')";
    $conn = pg_connect("host=localhost dbname=postgres user=postgres password=PO0STGRE3S");
    pg_query($conn, "SET SEARCH_PATH=caddie,PG_CATALOG");
    pg_query($conn, $sql);
    pg_close($conn);
    // Si on voulait vider le contenu de la session :
    // session_destroy();
    // unset($_SESSION);
    // Mais on veut transmettre l'information suivante :
    $_SESSION['msgN']="Ajout effectuée";
    $_SESSION['nom']="";
    $_SESSION['prenom']="";
    $_SESSION['annee']="";
    $_SESSION['mois']="";
    $_SESSION['jour']="";
    $_SESSION['sexe']="";
    $_SESSION['err']="";
    header("Location: exemple_caddie.php");
    exit();
}else{
    $_SESSION['msgN']="";
    header("Location: exemple_caddie.php");
    exit();
}
?>