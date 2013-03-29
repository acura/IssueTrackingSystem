
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="width: 100%;">
	<tr>
        <td  class="screenHeader" align="center">
              <span class="screenHeaderSpan">Change Properties</span>
		</td>
	</tr>
   <tr>
    	<td style="width: 100%;">
    		<div class="scrollableDiv" id="outterDiv" align="left">
				<table style="width: 100%;">
           			<tr>
						<td style="width: 100%;" valign="top">
	            			<table style="width: 100%;">
	            				<tr>
	            				<td style="width: 50%;">
		                          <table style="width:100%;">
		                        	<tr>
		                           		<td style="width: 20%;font-weight:bold;text-align:right;"><i>Status<font color="red">*</font>:</i></td>
		                         		<td style="width: 80%;">
		                         		<table>
											<s:textfield key="status" label="" labelSeparator="" maxlength="10" size="20"  onchange="capWords(this.value, this.name);" onkeyup=""/>		                         		
		                         		</table>
		                         	   </td>
		                           </tr>
		                       	 </table>
		                       </td>
		                       <td style="width: 50%;">
		                          <table style="width:100%;">
		                          <tr>
		                           <td style="width: 20%;font-weight:bold;text-align:right;"><i>Actual Start Date<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         		<table>
											<s:textfield key="actualStartDate" id="actualStartDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   </tr>
								   </table>
		                         	</td>
		                       </tr>
		                       
			            	 <tr>
					  		 <td style="width: 50%;">
					     	<table style="width:100%;">
							<tr>
							<td style="width:20%;font-weight:bold;text-align:right;"><i>Priority:</i></td>
							<td style="width:80%;text-align: left;">
							<table>
								<s:select list="#{'':'','High':'High', 'Medium':'Medium', 'Lower':'Lower'}"
									key="priority" label="" labelSeparator=""></s:select>			                         		
		               		</table>
						    </td>
						    </tr>
					</table>
				</td>
				
					                <td style="width: 50%;">
		                          <table style="width:100%;">
		                          <tr>
		                         	<td style="width: 20%;font-weight:bold;text-align:right;"><i>Actual End Date<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         	
		                         		<table>
											<s:textfield key="actualEndDate" id="actualEndDate" label="" labelSeparator="" maxlength="10" size="20" onkeyup="formatDate(this);" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   </tr>
								   </table>
		                         	</td>
								   </tr>
								
	            				 <tr>
		                         	<td style="width: 50%;">
		                          <table style="width:100%;">
		                           <tr>
		                         	<td style="width: 20%;font-weight:bold;text-align:right;"><i>Assignee<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         		<table>
		                         		    
		                         			<s:select list="developerList" listKey="optionId" listValue="optionText"
			                        		key="assignedTo" label="" labelSeparator="" ></s:select>	
		                         		</table>
		                         	</td>
		                         	</tr>
		                         	</table>
		                         	</td>
		                         	 <td style="width: 50%;">
		                          <table style="width:100%;">
		                          <tr>
		                        	<td style="width: 20%;font-weight:bold;text-align:right;"><i>Estimated Hours<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         		<table>
											<s:textfield key="estimatedHours" label="" labelSeparator="" maxlength="10" size="20"  onchange="capWords(this.value, this.name);" onkeyup="formatForNumeric(this)"/>		                         		
		                         		</table>
		                         	</td>
		                        </tr>
		                        </table>
		                         	</td>
		                        </tr>
		                          
								<tr>
									<td style="width: 50%;">
		                          <table style="width:100%;">
		                          <tr>
									<td style="width: 20%;font-weight:bold;text-align:right;"><i>Target Version<font color="red">*</font>:</i></td>
		                         	<td style="width: 80%;">
		                         	
		                         		<table>
											<s:textfield key="targetVersion" id="targetVersion" label="" labelSeparator="" maxlength="50" size="20" onkeyup="" onblur="validateDate(this, 'fromDateValMessage','TWIN_CENTURIES'); " />		                         		
		                         		</table>
		                         		</td>
								   </tr>
		                         </table>
		                         </td>
		                      </tr>
				</table>
				</td>
		      </tr>
		      </table>
			</div>
		</td>
	</tr>
	
	<tr>
        <td  class="screenHeader" align="center">
              <span class="screenHeaderSpan">Log Time</span>
		</td>
	</tr>
   
	   <tr>
    	<td style="width: 100%;">
    		<div class="scrollableDiv" id="outterDiv" align="left">
				<table style="width: 100%;">
				<s:hidden key="oid" value="%{oid}"/>
           			<tr>
						<td style="width: 100%;" valign="top">
	            			<table style="width: 100%;">
	            			<tr>
		                         	<td style="width: 50%;">
		                          <table style="width:100%;">
	            			
								<tr>
		                         	<td style="width: 20%;font-weight:bold;text-align:right;"><i>Spent Time<font color="red"></font>:</i></td>
		                         	<td style="width: 80%;">
		                         		<table>
											<s:textfield key="hours" label="" labelSeparator="" maxlength="50" size="20"  onchange="capWords(this.value, this.name);" onkeyup="formatForNumeric(this)"/>		                         		
		                         		</table>
		                         	</td>
		                         	</tr>
		                         	</table>
		                         	</td>
		                         	
		                         	<td style="width: 50%;">
		                          <table style="width:100%;">
		                          <tr>
		                         	<td  style="width:20%;font-weight:bold;text-align:right;"><i>Activity<font color="red">*</font>:</i></td>
		                        	<td style="width: 80%;">
		                         		<table>
		                         			<s:select list="#{'':'', 'Testing':'Testing', 'Coding':'Coding', 'Deployment':'Deployment','Demo':'Demo','Design':'Design','Document':'Document'}"
			                        		key="activity" label="" labelSeparator="" ></s:select>	
		                         		</table>
		                         	</td>
		                         	</tr>
		                         	</table>
		                         	</td>
		                        </tr>
		                        
		                        <tr>
		                        <td style="width: 100%;">
		                          <table style="width:100%;">
		                       <tr>
		                         	<td style="width: 10%;font-weight:bold;text-align:right;" colspan="2"><i>Comment<font color="red" ></font>:</i></td>
		                         	<td style="width: 90%;">
		                         		<table>
		                         		    <s:textarea name="comment" cols="70" rows="5"></s:textarea>
		                         		</table>
		                         	</td>
		                        </tr>
		                        </table>
		                         	</td>
		                        </tr>
		                        
				</table>
				</td>
		      </tr>
		      </table>
			</div>
		</td>
	</tr> 
	
		
	<tr>
	  <td style="width: 100%;">
       <div class="scrollableDiv" id="outterDiv" >
        <table style="width:100%;">
		 <tr>                 
		 <td style="width: 10%;font-weight:bold;text-align:right;" colspan="2"><i>Note<font color="red" ></font>:</i></td>
		 <td style="width: 90%;">
		     <table>
		             <s:textarea name="note" cols="70" rows="5"></s:textarea>
		     </table>
		     </td>
		     </tr>
         </table>
         </div>
	 </td>
  </tr>
	
	<tr>
   		<td style="text-align: center;">
   			<%--<input  type="submit" value="SAVE"/> --%>
			  <jsp:include page="commonSubmit.jsp"></jsp:include> 
   		</td>
   	</tr>
</table>

   		
		      