<%@page import="pojo.ProductPOJO"%>
<%@page import="dao.ProductManagementDAO"%>

<%

String productId = request.getParameter("prodId");
String productName = request.getParameter("prodName");
String productCategory = request.getParameter("prodCategory");
Integer productPrice = Integer.parseInt(request.getParameter("prodPrice"));

ProductPOJO product = new ProductPOJO(productId,productName,productCategory,productPrice);

int status = ProductManagementDAO.updateProduct(product);
if(status == 1)
{
	response.sendRedirect("viewProduct.jsp"); 
}
else
{
	response.sendRedirect("error.jsp"); 
}

%>