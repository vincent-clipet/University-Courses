<%!
	int count = 0;
%>

<%
	count++;
%>

<html>

	<head>
	
		<script>
			req = new XMLHttpRequest();
			req.onreadystatechange = process;
			
			function request()
			{
				req.open("GET", "data.txt", true);
				//req.onreadystatechange = process;
				req.send(null);
			}
			
			function process()
			{
				if (req.readyState == 4 && req.status == 200)
				{
					document.getElementById("texte").value = req.responseText;
				}
			}
			
			
		</script>
	</head>
	
	
	
	<body>
	
		Affichages : <%= count %><br /><hr>
	
		<form>
			<input type="text" id="texte" />
			<input type="button" id="bouton" value="valider" onClick="request()" />
		</form>
		
	</body>
	
</html>
