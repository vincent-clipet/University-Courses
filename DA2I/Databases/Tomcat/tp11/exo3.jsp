<html>

	<head>
	
		<script>			
			function request()
			{
				var url = "nb.jsp";
				req.open("GET", url, true);
				req.onreadystatechange = process;
				req.send(null);
			}
			
			function process()
			{
				if (req.readyState == 4 && req.status == 200)
				{
					var answer = req.responseText;
					var v = document.getElementById("info");
					v.value = answer;
				}
			}
			
			var req = new XMLHttpRequest();	
			setInterval("request()", 1000);
		</script>
	</head>
	
	
	
	<body>
	
		<%! int nb = 0; %>
		<h2>Page rechargee <%= nb++ %> fois</h2>
		
		<input type="text" id="info" />
		<input type="button" id="bouton" value="Mise a jour" onClick="request()" />
		
	</body>
	
</html>
