<html>

	<head>
		<script type="text/javascript" src="./prototype.js"></script>
		
		<script>
			function makeRequest()
			{
				var search = document.getElementById("input").value;
				
				new Ajax.Request('../q3_process.jsp?search=' + search, {
					onSuccess: function(answer) {
						var xml = answer.responseXML;
						if (xml.getElementsByTagName("id")[0].firstChild == null)
							document.getElementById("erreur").innerHTML = "ID inexistant";
						else
							document.getElementById("erreur").innerHTML = "";
							
						document.getElementById("id").value = xml.getElementsByTagName("id")[0].firstChild.nodeValue;
						document.getElementById("nom").value = xml.getElementsByTagName("nom")[0].firstChild.nodeValue;
						document.getElementById("prenom").value = xml.getElementsByTagName("prenom")[0].firstChild.nodeValue;
						document.getElementById("login").value = xml.getElementsByTagName("login")[0].firstChild.nodeValue;
						document.getElementById("datenaiss").value = xml.getElementsByTagName("datenaiss")[0].firstChild.nodeValue;
					}
				} );
			}
		</script>
	</head>
	
	
	
	<body>
		<input type="text" onkeyup="makeRequest()" id="input" ><br />
		<span id="erreur"></span>
		<hr>
		<form>
			<input type="text" id="id" ><br />
			<input type="text" id="login" ><br />
			<input type="text" id="nom" ><br />
			<input type="text" id="prenom" ><br />
			<input type="text" id="datenaiss" ><br />
		</form>
	</body>
	
</html>
