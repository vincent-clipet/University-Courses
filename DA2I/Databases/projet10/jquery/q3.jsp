<html>

	<head>
		<script type="text/javascript" src="./jquery.js"></script>
		<script>
			function makeRequest()
			{
				var src = $("input")[0].value;
				
				$.ajax( {
					type: "GET",
					url: "../q3_process.jsp?search=" + src,
					dataType: "xml",
					success: function(xml) {
						$("#id")[0].value = $(xml).find('id').text();
						$("#nom")[0].value = $(xml).find('prenom').text();
						$("#prenom")[0].value = $(xml).find('nom').text();
						$("#login")[0].value = $(xml).find('login').text();
						$("#datenaiss")[0].value = $(xml).find('datenaiss').text();
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
