<html>

	<head>
		<script type="text/javascript" src="./prototype.js"></script>
		
		<script>
			
			function makeRequest()
			{
				var search = document.getElementById("input").value;
				
				new Ajax.Request('../q2_process.jsp?search=' + search, {
					onSuccess: function(answer) {						
						var arr = answer.responseText.split("\n");
						var names = "";
						
						for (var i = 0; i < arr.length; i++)
							if (arr[i].localeCompare("") != 0)
								names += arr[i].split(";")[2] + "\n";
						
						document.getElementById("result").innerHTML = names;
					}
				} );
			}
		</script>
	</head>
	
	
	
	<body>
		<input type="text" onkeyup="makeRequest()" id="input" ><hr>
		<textarea rows='5' cols='50' id="result"></textarea>
	</body>
	
</html>
