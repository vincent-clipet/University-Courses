<html>

	<head>
		<script type="text/javascript" src="./AjaxInteraction.js"></script>
		<script>
		
			function callbackRequest(answer)
			{
				var arr = answer.split("\n");
				var names = "";
				
				for (var i = 0; i < arr.length; i++)
					if (arr[i].localeCompare("") != 0)
						names += arr[i].split(";")[2] + "\n";
				
				document.getElementById("result").innerHTML = names;
			}
		
			function makeRequest()
			{
				var src = document.getElementById("input").value;
				if (src.localeCompare("") == 0) return;
				var ajax = new AjaxInteraction("../q2_process.jsp?search=" + src, callbackRequest, false);
				ajax.doGet();
			}
		</script>
	</head>
	
	
	
	<body>
		<input type="text" onkeyup="makeRequest()" id="input" ><hr>
		<textarea rows='5' cols='50' id="result"></textarea>
	</body>
	
</html>
