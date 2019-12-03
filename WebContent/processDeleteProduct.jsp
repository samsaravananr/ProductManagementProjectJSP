<%@page import="dao.ProductManagementDAO"%>
<%@page import="pojo.ProductPOJO"%>

<%

String productId = request.getParameter("prodId");

int status = ProductManagementDAO.deleteProduct(productId);
if(status == 1)
{
	response.sendRedirect("viewProduct.jsp"); 
}
else
{
	response.sendRedirect("error.jsp"); 
}

%>