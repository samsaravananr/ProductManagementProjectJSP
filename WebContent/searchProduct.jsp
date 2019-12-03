<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.ProductPOJO" %>
<%@ page import="dao.ProductManagementDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>  
<div align="center" style="padding-top:25px;">
	<form action="searchProduct.jsp">
		<label>Enter Product ID: </label>
		<input type="text" name="prodId" size="25" class="searchTextField"/>
		<button class="actionBtn">Search</button>
	</form>
</div> 

	<table align="center" class="productTable">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>Price</th>
				<th colspan="2">Actions</th>
			</tr> 
		</thead>
		<%
			String productId = request.getParameter("prodId");
			if(productId != null)
			{
				ProductPOJO p = ProductManagementDAO.getProductById(productId);
			
				if(p != null)
				{
		%>
			<tr>
				<td><%=p.getProductID()%></td>
				<td><%=p.getProductName()%></td>
				<td><%=p.getProductCategory()%></td>
				<td><%= p.getProductPrice() %></td>
				<td><button class="actionBtn" onclick="location.href = 'editProduct.jsp?prodId=<%= p.getProductID()%>';">Edit</button></td>
				<td><button class="actionBtn" onclick="location.href = 'processDeleteProduct.jsp?prodId=<%= p.getProductID()%>';">Delete</button></td>
			</tr>
	    <%		}
				else
				{
		%>
			<tr>
				<td colspan="5">No record to display</td>
			</tr>
		<% 
				}
			}
			else 
			{
		%>
			<tr>
				<td colspan="5">No record to display</td>
			</tr>
		<% 
			}
		%>
	</table>


</body>
</html>