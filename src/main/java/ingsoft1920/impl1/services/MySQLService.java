package ingsoft1920.impl1.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class MySQLService {
	private final String host="";
	private final String database="";
	private final String username="";
	private final String password="";
	private final int port=0;
	final String driver = "com.mysql.jdbc.Driver";
	
	private Connection con;
	private boolean connected=false;
	
	public MySQLService() {
		Connection conn = null;
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database
				+ "?useSSL=false&allowMultiQueries=true&serverTimezone=" 
				+ TimeZone.getDefault().getID();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        this.con=conn;
        this.connected=true;
	}
	
	public Connection getConnection() {
		if(this.connected){
			return this.con;
		}else{return null;}
	}

}
