<html>

	<head>
		<script type="text/javascript" src="./jquery.js"></script>
		
		<script>
			window.onload = makeRequest;
			setInterval(makeRequest, 5000);
			
			function makeRequest()
			{
				processRequest("DESC", "#last");
				processRequest("ASC", "#first");
			}

			function processRequest(search, ident)
			{
				$.ajax( {
					type: "GET",
					url: "../q4_process.jsp?search=" + search,
					dataType: "xml",
					success: function(xml) {
						var txt = "";
						
						$(xml).find('personne').each(function() {
							txt += "id: " + $(this).find('id').text() + "\tnom: " + $(this).find('prenom').text() + $(this).find('nom').text() + "\n";
						});
						
						$(ident)[0].innerHTML = txt;
					}
				} );
			}
		</script>
	</head>
	
	
	
	<body>
		<textarea rows='4' cols='50' id="first"></textarea>
		<textarea rows='4' cols='50' id="last"></textarea>
		<br />
		<input type="button" onClick="makeRequest()" id="refresh" value="refresh" >
	</body>
	
</html>
