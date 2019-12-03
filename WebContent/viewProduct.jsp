<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.ProductManagementDAO"%>
<%@page import="pojo.ProductPOJO"%>
<%@page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp" %>  

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
			List<ProductPOJO> productList = ProductManagementDAO.getAllProducts();
			for (ProductPOJO p : productList) {
		%>
		<tr>
			<td><%=p.getProductID()%></td>
			<td><%=p.getProductName()%></td>
			<td><%=p.getProductCategory()%></td>
			<td><%=p.getProductPrice()%></td>
			<td><button class="actionBtn" onclick="location.href = 'editProduct.jsp?prodId=<%= p.getProductID()%>';">Edit</button></td>
			<td><button class="actionBtn" onclick="location.href = 'processDeleteProduct.jsp?prodId=<%= p.getProductID()%>';">Delete</button></td>
		</tr>

		<%
}
%>
	</table>

</body>
</html>