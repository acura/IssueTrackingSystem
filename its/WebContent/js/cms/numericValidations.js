function formatForNumeric(obj)
{
	var regex = /^\d\d*\.?\d*$/;

	if (regex.test(obj.value) == false)
	{
		obj.value='';
		return;
	}
	return; 
}

function isNumberKey(evt)
{
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function numberFormat(obj)
{
	var regex = /^\d\d*\/?\d*$/;

	if (regex.test(obj.value) == false)
	{
		obj.value='';
		return;
	}
	return; 
}
