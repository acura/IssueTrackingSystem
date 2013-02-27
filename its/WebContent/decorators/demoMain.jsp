<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

	<head>
      <jsp:include page="../hms/include.jsp"></jsp:include>
		<decorator:head/>
	</head>

	<body>
      <div class="container">

      <script type="text/javascript">
         <!-- highlight active example based on the parameter passed from request -->
         $(document).ready(function(){
            $("#btn-" + "<%=request.getParameter("type")%>").removeClass("normal");
            $("#btn-" + "<%=request.getParameter("type")%>").addClass("active");
         });
      </script>

      <decorator:body/>			

      </div>
	</body>

</html>
