package edu.cvtc.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zschullo
 *
 */
public class DBUtility {

	public static final int TIMEOUT = 30;
	
	private static final String CONNECTION = "jdbc:sqlite:movie.db";
	private static final String DRIVER_NAME = "org.sqlite.JDBC";
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		//Register the driver
		Class.forName(DRIVER_NAME);
		
		//Create database connection
		return DriverManager.getConnection(CONNECTION);
		
	}
	
	public static void closeConnections(final Connection connection, final Statement statement) {
		
		try {
			if (null != connection) {
				connection.close();
			}
			if (null != statement) {
				statement.close();
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
