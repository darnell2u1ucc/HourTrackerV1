<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.info"%>
<%@ page import="org.hibernate.Query"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 
<%List<info> users = (List<info>)request.getAttribute("recordlist");%>
<style>
table,th,td{
border: 1px solid black;

}
td{
text-align:right;
}
</style>
<table>
<tr>
<th>MONTH</th>
<th>DAY</th>
<th>YEAR</th>
<th>HOURS</th>
</tr>

<%for(info u: users){ %>
<tr>
<td><%=u.getMonth() %></td>
<td><%=u.getDay() %></td>
<td><%=u.getYear() %></td>
<td><%=u.getHours() %></td>
</tr>

<%} %>
</table>
<form method="post" action="SimpleServlet">
<br>
<br>
<input type="submit" name="submitbutton" value="main">
</form>

</body>
</html>