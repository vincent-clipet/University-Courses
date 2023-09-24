<html>

	<head>
		<script type="text/javascript" src="./AjaxInteraction.js"></script>
		
		<script>
			function callbackRequest(answer)
			{				
				if (answer.getElementsByTagName("id")[0].firstChild == null)
					document.getElementById("erreur").innerHTML = "ID inexistant";
				else
					document.getElementById("erreur").innerHTML = "";
					
				
				document.getElementById("id").value = answer.getElementsByTagName("id")[0].firstChild.nodeValue;
				document.getElementById("nom").value = answer.getElementsByTagName("nom")[0].firstChild.nodeValue;
				document.getElementById("prenom").value = answer.getElementsByTagName("prenom")[0].firstChild.nodeValue;
				document.getElementById("login").value = answer.getElementsByTagName("login")[0].firstChild.nodeValue;
				document.getElementById("datenaiss").value = answer.getElementsByTagName("datenaiss")[0].firstChild.nodeValue;
			}

			function makeRequest()
			{
				var src = document.getElementById("input").value;
				var ajax = new AjaxInteraction("../q3_process.jsp?search=" + src, callbackRequest, true);
				ajax.doGet();
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
