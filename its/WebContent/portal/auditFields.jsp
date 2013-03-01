<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<table style="width:100%">
 <tr>
	<td style="width:8%;text-align:center;"><b><i>Audit Fields:</i></b></td>
	<td style="width:92%;text-align:left;">
	<div class="subComponentDiv">
	<table style="width:98%">
	<tr>
 		<td style="width:43%; padding-left:79px">
 		<table>
   			<tr>
   				<td style="text-align:right;"><i><b>Created By:</b></i></td>
   				<td style="text-align:left;">
   					<table>
   					<tr>
   						<td class="auditField">
   							<s:text name="createdBy"></s:text>
   						</td>
   						<td><s:hidden name="hiddenCreatedBy" /></td>
   					</tr>
   					</table>
   				</td>
   			</tr>
   			<tr>
   				<td style="text-align:right;"><i><b>Created Date:</b></i></td>
   				<td style="text-align:left;">
   					<table>
   					<tr>
   						<td class="auditField">
   							<s:text name="createdDate"></s:text>
   						</td>
   						<td><s:hidden name="hiddenCreatedDate" /></td>
   					</tr>
   					</table>
   				</td>
   			</tr>
   		</table>
   		</td>
   		
 		
 		<td style="width:50%;text-align:left;">
 		<table>
   			<tr>
   				<td style="text-align:right;"><i><b>Last Updated By:</b></i></td>
   				<td style="text-align:left;">
   					<table>
   					<tr>
   						<td class="auditField">
   							<s:text name="lastUpdatedBy"></s:text>
   						</td>
   						<td><s:hidden name="hiddenLastUpdatedBy" /></td>
   					</tr>
   					</table>
   				</td>
   			</tr>
   			<tr>
   				<td style="text-align:right;"><i><b>Last Updated Date:</b></i></td>
   				<td style="text-align:left;">
   					<table>
   					<tr>
   						<td class="auditField">
   							<s:text name="lastUpdatedDate"></s:text>
   						</td>
   						<td><s:hidden name="hiddenLastUpdatedDate" /></td>
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
</table>		
