package DbConnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
        public static final String USERNAME = "vcrCMROJ6c";
    public static final String PASSWORD = "CbPFdec3fq";
    public static final String CONN = "jdbc:mysql://remotemysql.com:3306/vcrCMROJ6c";
    //public static final String USERNAME = "XFUdwTJBF2";
    //public static final String PASSWORD = "8k74KNK3no";
    //public static final String CONN = "jdbc:mysql://remotemysql.com:3306/XFUdwTJBF2";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
    }
}