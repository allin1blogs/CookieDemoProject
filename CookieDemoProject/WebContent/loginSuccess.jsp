<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
<%
String userName=null;
Cookie[] cookies=request.getCookies();
if(cookies !=null) {
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("user")){
			userName=cookie.getValue();
			
		}
	}
	}
if(userName ==null){
	response.sendRedirect("index.html");
	
}
%>

<h3><%=userName %>: Login Successfully</h3><br/>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>