package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.ProductPOJO;

public class ProductManagementDAO 
{
	public static List<ProductPOJO> getAllProducts() throws Exception
	{
		List<ProductPOJO> productList = new ArrayList<ProductPOJO>();
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM product");
			while(rs.next())
			{
				ProductPOJO product = new ProductPOJO(rs.getString("PROD_ID"),rs.getString("PROD_NAME"),rs.getString("PROD_CATEGORY"),rs.getInt("PROD_PRICE"));
				productList.add(product);
			}
			
			DBUtil.closeConnection(conn);
			
		return productList;
	}
	
	public static int addProduct(ProductPOJO product) throws Exception
	{
		int status = 0;
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
			ps.setString(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
			return status;
	}
	
	public static ProductPOJO getProductById(String productId) throws Exception
	{
		ProductPOJO product = null;
		
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				product = new ProductPOJO(rs.getString("PROD_ID"),rs.getString("PROD_NAME"),rs.getString("PROD_CATEGORY"),rs.getInt("PROD_PRICE"));
			}
				
		return product;
	}

	public static int updateProduct(ProductPOJO product) throws Exception
	{
		int status = 0;
		
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("UPDATE product SET PROD_NAME=?, PROD_CATEGORY=?, PROD_PRICE=? WHERE PROD_ID=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductID());
			status = ps.executeUpdate();
		
		
		return status;
	}
	
	public static int deleteProduct(String productId) throws Exception
	{
		int status = 0;
			Connection con = DBUtil.getConnection();
			PreparedStatement ps= con.prepareStatement("DELETE FROM product where PROD_ID = ?");
			ps.setString(1, productId);
			status = ps.executeUpdate();
		return status;
	}

	
}
