<html>

	<head>
		<script type="text/javascript" src="./jquery.js"></script>
		<script>
			function makeRequest()
			{
				var src = $("#input")[0].value;
				if (src.localeCompare("") == 0) return;
				
				$.get( "../q2_process.jsp?search=" + src, function(answer) {
					var arr = answer.split("\n");
					var names = "";
					
					for (var i = 0; i < arr.length; i++)
						if (arr[i].localeCompare("") != 0)
							names += arr[i].split(";")[2] + "\n";
					
					$("#result")[0].innerHTML = names;
				});
			}
		</script>
	</head>
	
	
	
	<body>
		<input type="text" onkeyup="makeRequest()" id="input" ><hr>
		<textarea rows='5' cols='50' id="result"></textarea>
	</body>
	
</html>
