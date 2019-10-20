package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lijie
 * @date 2017年12月4日
 */
public class DBManager {
	private static final String URL = "jdbc:mysql://172.28.164.31/mysql?useSSL=true";
	private static final String NAME = "root";
	private static final String PASSWORD = "lijie160582";
	private static Connection conn = null;
	private static final String driver = "com.mysql.jdbc.Driver";

	// 对外提供一个方法来获取数据库连接
	public static Connection getConnection() {
		try {
			// 1.加载驱动程序
			Class.forName(driver);
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到数据库驱动程序");
		} catch (SQLException e) {
			System.out.println("数据库连接时出现异常，可能由于数据库服务未启动造成，请先启动数据库服务");
		}
		return conn;
	}
}
