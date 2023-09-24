<html>

	<head>
		<script type="text/javascript" src="./jquery.js"></script>
		<script>		
			function makeRequest()
			{
				$("#result").load("../q1_process.jsp");
			}
			
			setInterval(makeRequest, 5000);
			window.onload = makeRequest;
		</script>
	</head>
	
	
	<body>
		Il y a actuellement <span id="result"></span> enregistrements dans la table 'personne'.
	</body>
	
</html>
