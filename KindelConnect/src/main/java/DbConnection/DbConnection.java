package DbConnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
        public static final String USERNAME = "sql4404765";
    public static final String PASSWORD = "7G5r8rfQ9A";
    public static final String CONN = "jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4404765";
    //public static final String USERNAME = "XFUdwTJBF2";
    //public static final String PASSWORD = "8k74KNK3no";
    //public static final String CONN = "jdbc:mysql://remotemysql.com:3306/XFUdwTJBF2";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
    }
}