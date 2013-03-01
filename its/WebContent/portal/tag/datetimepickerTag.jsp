<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
  <head> 
      <sx:head parseContent="true"/>
  </head>
  <body>
    <h1><span style="background-color: #FFFFcc"></span></h1>
    <sx:datetimepicker name="checkupDate" label="Checkup Date (dd-MM-yyyy)" displayFormat="dd-MM-yyyy" />    
  </body>
</html>
