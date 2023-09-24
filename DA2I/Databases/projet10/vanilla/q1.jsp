<html>

	<head>
		<script type="text/javascript" src="./AjaxInteraction.js"></script>
		<script>
			function callbackRequest(answer)
			{
				document.getElementById("result").innerHTML = answer;
			}
		
			function makeRequest()
			{
				var ajax = new AjaxInteraction("../q1_process.jsp", callbackRequest, false);
				ajax.doGet();
			}
			
			setInterval(makeRequest, 5000);
			window.onload = makeRequest;
		</script>
	</head>
	
	
	
	<body>
		
		Il y a actuellement <span id="result"></span> enregistrements dans la table 'personne'.
		
	</body>
	
</html>
