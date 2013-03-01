
function closeAll() 
{
	try
	{
		for (i=0; i<window.openWins.length; i++)
		{
			if (window.openWins[i] && !window.openWins[i].closed)
			{
				window.openWins[i].close();	
			}
			
		}
	}
	catch (e) { }
}	 
