package dbUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	
	private static final String SQLCONN = "jdbc:sqlite:Bsystem.sqlite";

	public static Connection getConnection()
			throws SQLException{
		
		try
	    {
	      Class.forName("org.sqlite.JDBC");
	      
	      return DriverManager.getConnection(SQLCONN);
	    }
	    catch (ClassNotFoundException|SQLException ex)
	    {
	      ex.printStackTrace();
	    }
	    return null;
	}
}