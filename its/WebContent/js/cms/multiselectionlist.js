function listbox_selectall(listID, isSelect, srcId, destId,flagBillPayment) 
{
	  var listbox = document.getElementById(listID);         

	  for(var count=0; count < listbox.options.length; count++) 
		 {             
			 listbox.options[count].selected = isSelect;     
		 } 
	  listbox_moveacross(srcId, destId, flagBillPayment);
}

function listbox_selectAllForSubmit(listID, isSelect) 
{
	var listbox = document.getElementById(listID);         

	for(var count=0; count < listbox.options.length; count++) 
	{             
		listbox.options[count].selected = isSelect;     
	} 
}

function listbox_removeall(listID, isSelect,srcId,destId,flagBillPayment) 
{
	  var listbox = document.getElementById(listID);         

	  for(var count=0; count < listbox.options.length; count++) 
		      {             
			      listbox.options[count].selected = isSelect;     
		      } 

	 listbox_moveacross(srcId, destId, flagBillPayment);
}


function listbox_moveacross(sourceID, destID, flagBillPayment) 
{     
	
	var src = document.getElementById(sourceID);
  	var dest = document.getElementById(destID); 
  	for(var count=0; count < src.options.length; count++) 
  	{
       if(src.options[count].selected == true) 
		{   
    	    var option = src.options[count];     
            var newOption = document.createElement("option");                 
            newOption.value = option.value;                 
            newOption.text = option.text;                 
            newOption.selected = true;                 
            try 
            	{                          
            		dest.add(newOption, null);
            		src.remove(count, null);                  
            	}
        	catch(error) 
        		{ 
        		    dest.add(newOption);                          
        		    src.remove(count);                  
        		}                 
    		count--;         
        }
	 }
  	
  	if (flagBillPayment == true)
  	{
  		calculateBilltoPay();	
  	}
  	else
  	{
  		sortlist(destID);	
  	}
  	
}

function sortlist(destID) 
{ 
	  var lb = document.getElementById(destID);
      arrTexts = new Array(); 
	      for(i=0; i<lb.length; i++) 
       { 
          	arrTexts[i] = lb.options[i].text+':'+lb.options[i].value; 
       } 

         arrTexts.sort(); 

     for(i=0; i<lb.length; i++) 
        { 
            el = arrTexts[i].split(':'); 
            lb.options[i].text = el[0]; 
            lb.options[i].value = el[1]; 
       } 
}

function calculateBilltoPay()
{
	var sumOfTestAmount = 0.0;
	var selectedTestsOptionsLength = document.getElementById('selectedTests').options.length;
	var tmpCompletedTestPricesVal = document.getElementById('tmpCompletedTestPrices').value;
	var completedTestPrices = new Array();
	
	for(var i=0; i<	selectedTestsOptionsLength; i++)
	{	
		var amountSelectedTestArray = document.getElementById('selectedTests').options[i].value.split(':');
		sumOfTestAmount = sumOfTestAmount + parseFloat(amountSelectedTestArray[1]);
	}
	
	if (tmpCompletedTestPricesVal != null && tmpCompletedTestPricesVal != '')
	{
		completedTestPrices = tmpCompletedTestPricesVal.split(':');
		
		for (var j=0; j<completedTestPrices.length; j++)
		{
			sumOfTestAmount = sumOfTestAmount + parseFloat(completedTestPrices[j]);
		}
	}
	
	document.getElementById('editBillPayment_billToPay').value = sumOfTestAmount;
}
