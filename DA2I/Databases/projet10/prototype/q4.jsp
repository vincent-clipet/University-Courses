<html>

	<head>
		<script type="text/javascript" src="./prototype.js"></script>
		
		<script>
			window.onload = makeRequest;
			setInterval(makeRequest, 5000);
			
			function makeRequest()
			{
				processRequest("DESC", "last");
				processRequest("ASC", "first");
			}
		
			function processRequest(search, ident)
			{
				new Ajax.Request('../q4_process.jsp?search=' + search, {
					onSuccess: function(answer) {
						var xml = answer.responseXML;
						var txt = "";
				
						for (var i = 0; i < 3; i++)
							txt += "id: " + xml.getElementsByTagName("id")[i].firstChild.nodeValue + "\tnom: " + xml.getElementsByTagName("prenom")[i].firstChild.nodeValue + xml.getElementsByTagName("nom")[i].firstChild.nodeValue + "\n";
							
						document.getElementById(ident).innerHTML = txt;
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
