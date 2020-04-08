<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/JavaScript">


function checkRadio(event)
	{
		var str= document.finalform.doThisToItem.value;
			if((str==null) || (str==""))
				{
				alert('Please enter a selection');
				return false;
				}
	}
</script>

<meta charset="ISO-8859-1">
<title>polish list</title>
</head>
<body>
<form name="finalform" method ="post" action = "navigationServlet" onSubmit= "return checkRadio(event);">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type ="radio" name ="id" value="${currentitem.id}"></td>
<td>${currentitem.brand}</td>
<td>${currentitem.color}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type = "submit" value = "add" name="doThisToItem">
</form>

</body>
</html>