<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href ="page1.css"/>
	<title>Page 1</title>
</head>
<body>

<form method="post" action="page1_action.jsp">
    	<fieldset>
        	<legend> Veuillez saisir votre identité  </legend>
	  		<table>
	  		<tr>
      		<td><label for="civilite">Civilité</label> : </td>
      		<td>
      		<input type="radio" value="Mlle" name="civilite" id="civilite" /> Mlle 
      		<input type="radio" value="Mme" name="civilite" id="civilite" /> Mme 
      		<input type="radio" value="M." name="civilite" id="civilite" /> M.
      		</td>
      		</tr>
      		<tr>
      		<td><label for="nom">Nom</label> :</td>
      		<td><input type="text" name="nom" id="nom" /></td>
      		</tr>
      		<tr>
      		<td><label for="prenom">Prénom</label> :</td>
      		<td><input type="text" name="prenom" id="prenom" /></td>
      		</tr>
      		<tr>
      		<td><label for="age">Age</label> :</td>
      		<td>
      		<select name="age" id="age">
      		<% for (int i=0;i<=150;i++){
      			out.println("<option value=\""+i+"\">" + i);
      		}%>
      		</select>
      		</td>
      		</tr>
      		<tr>
      		<td colspan="2"><input type="submit" value="Suivant" /></td>
      		</tr>
      		</table>
      	</fieldset>	
</form>
</body>
</html>