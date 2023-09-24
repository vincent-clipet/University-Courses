<html>

	<head>
		<script type="text/javascript" src="./prototype.js"></script>
		
		<script>
		new Ajax.PeriodicalUpdater("result", '../q1_process.jsp', {
			method: 'get',
			frequency: 5,
			decay: 1
		});
		</script>
	</head>
	
	<body>
		Il y a actuellement <span id="result"></span> enregistrements dans la table 'personne'.
	</body>
	
</html>
