function AjaxInteraction(url, callbackFunction, useXML)
{
	var req = init();
	req.onreadystatechange = processRequest;

	function init()
	{
		if (window.ActiveXObject)
			return new ActiveXObject("Microsoft.XMLHTTP");
		else // if (window.XMLHttpRequest)
			return new XMLHttpRequest();
	}

	function processRequest ()
	{
		if (req.readyState == 4)
		{
			if (req.status == 200)
			{
				if (useXML)
					callbackFunction(req.responseXML);
				else
					callbackFunction(req.responseText);
			}
			else if (req.status == 500)
			{
				if (useXML)
					console.warn(req.responseXML);
				else
					console.warn(req.responseText);
			}
		}
	}

	this.doGet = function()
	{
		req.open("GET", url, true);
		req.send();
	}

	this.doPost = function(body)
	{
		req.open("POST", url, true);
				
		if (useXML)
			req.setRequestHeader("Content-Type", "text/xml");
		else
			req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
		req.send(body);
	}
}
