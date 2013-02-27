function addOption(selectbox,text,value)
{
	var optn = document.createElement("OPTION");
	optn.text = text;
	optn.value = value;
	selectbox.options.add(optn);
}

/*
** The code that will go in updatePage function to 
** populate the date dropdown.
var resText = '10-10-2010:11-10-2010:12-10-2010:';
var dateArray = resText.split(':');
var dateArrayLength = dateArray.length;
var dateField = document.getElementById('testDate');
addOption(dateField, '', '');
for (var i=0; i < dateArrayLength; i++)
{
	addOption(dateField, dateArray[i], dateArray[i]);
}
*/
