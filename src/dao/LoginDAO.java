package dao;

import java.sql.*;

import dbutil.DBUtil;
import pojo.LoginInfoPOJO;

public class LoginDAO 
{

	public static boolean isUserValid(LoginInfoPOJO userDetails) throws Exception
	{
		boolean validStatus=false;
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * from login_info where USER_NAME='"+userDetails.getUsername()+"' and PASSWORD='"+userDetails.getPassword()+"'");
		while (rs.next())
		{
			validStatus=true;
		}
		DBUtil.closeConnection(con);
		return validStatus;
		
	}
}
