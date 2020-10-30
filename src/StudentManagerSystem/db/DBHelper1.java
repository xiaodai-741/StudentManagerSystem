package StudentManagerSystem.db;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper1 {
    private static final String DRIVER;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        Properties pro = new Properties();
        InputStream in = DBHelper1.class.getClassLoader().getResourceAsStream("DB.properties");
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER = pro.getProperty("DRIVER");
        URL = pro.getProperty("URL");
        USER = pro.getProperty("USER");
        PASSWORD = pro.getProperty("PASSWORD");

    }

    /**
     * 获得 connection 连接
     * @return Connection 连接
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getconn() throws ClassNotFoundException, SQLException {
        //找驱动
        Class.forName(DRIVER);
        //建连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}
