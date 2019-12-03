package pojo;

public class LoginInfoPOJO 
{

	String username;
	String password;
	
	public LoginInfoPOJO() 
	{
	
		// TODO Auto-generated constructor stub
	}

	public LoginInfoPOJO(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginInfoPOJO [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
