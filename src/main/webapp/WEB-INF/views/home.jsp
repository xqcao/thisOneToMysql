<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    	<h1>User Data</h1>
    	<form action="user.do" method="post">
    		<table>
    			<tr>
    				<td>User ID</td>
    				<td><input name="userId" value="userId"></td>
    			</tr>
    			<tr>
    				<td>User name</td>
    				<td><input name="username" value="username"></td>
    			</tr>
    			<tr>
    				<td>User password</td>
    				<td><input name="password" value="password"></td>
    			</tr>
    			<tr>
    				<td>User Email</td>
    				<td><input name="email" value="email"></td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" name="action" value="Add" />
    					<input type="submit" name="action" value="Edit" />
    					<input type="submit" name="action" value="Delete" />
    					<input type="submit" name="action" value="Search" />
    				</td>
    			</tr>
    		</table>
    	
    	
    	
    	</form>
    
        <div align="center">
	        <h1>Contact List</h1>
        	<table border="1">
	        	<th>UserId</th>
	        	<th>Username</th>
	        	<th>Password</th>
	        	<th>Email</th>
	        	
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        	<!-- 	<td>${status.index + 1}</td>  -->
	        		<td>${user.id}</td>
	        		<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
							
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
