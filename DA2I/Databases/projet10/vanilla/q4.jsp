<html>

	<head>
		<script type="text/javascript" src="./AjaxInteraction.js"></script>
		
		<script>
			window.onload = makeRequest;
			setInterval(makeRequest, 5000);
		
			function callbackRequest(type, answer)
			{
				var txt = "";
				
				for (var i = 0; i < 3; i++)
					txt += "id: " + answer.getElementsByTagName("id")[i].firstChild.nodeValue + "\tnom: " + answer.getElementsByTagName("prenom")[i].firstChild.nodeValue + answer.getElementsByTagName("nom")[i].firstChild.nodeValue + "\n";
					
				document.getElementById(type).innerHTML = txt;
			}
		
			function callbackRequestFirst(answer)
			{
				callbackRequest("first", answer);
			}
			
			function callbackRequestLast(answer)
			{
				callbackRequest("last", answer);
			}

			function makeRequest()
			{
				var ajax = new AjaxInteraction("../q4_process.jsp?search=ASC", callbackRequestFirst, true);
				ajax.doGet();
				var ajax = new AjaxInteraction("../q4_process.jsp?search=DESC", callbackRequestLast, true);
				ajax.doGet();
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
