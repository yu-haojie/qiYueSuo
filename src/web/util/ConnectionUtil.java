package web.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    /**
     * 获取jdbc连接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/qiyuesuo";
        String user = "root";
        String password = "root";
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

}
