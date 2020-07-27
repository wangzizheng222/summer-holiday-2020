package phase_4.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 数据库操作工具类
 */
public class DBUtils {
    //数据库驱动
    public static String DRIVER;
    //数据库连接地址/路径
    public static String URL;
    //数据库用户名
    public static String USERNAME;
    //数据库密码
    public static String PASSWORD;

    private static final ResourceBundle rb = ResourceBundle.getBundle("phase_4.util.DataBase_config");

    private DBUtils(){}

    //使用静态块加载驱动程序
    static{
        URL = rb.getString("url");
        USERNAME = rb.getString("username");
        PASSWORD = rb.getString("password");
        DRIVER = rb.getString("driver");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义一个获取数据库连接的方法
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;
    }


    //关闭数据库连接
    public static void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
