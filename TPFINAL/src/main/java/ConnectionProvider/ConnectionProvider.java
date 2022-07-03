package ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/";
			String dbName = "inventario?enabledTLSProtocols=TLSv1.2";
			String dbUsername = "root";
			String dbPassword = "123";
			
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl + dbName, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
}