package pers.cocoadel.user.platform.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionManager {

    private static final Logger logger = Logger.getLogger(JdbcHelper.class.getName());

    private Connection connection;

    public static final String DROP_USERS_TABLE_DDL_SQL = "DROP TABLE users";

    public static final String CREATE_USERS_TABLE_DDL_SQL = "CREATE TABLE users(" +
            "id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            "name VARCHAR(16) NOT NULL, " +
            "password VARCHAR(64) NOT NULL, " +
            "email VARCHAR(64) NOT NULL, " +
            "phoneNumber VARCHAR(64) NOT NULL" +
            ")";

    public static final String INSERT_USER_DML_SQL = "INSERT INTO users(name,password,email,phoneNumber) VALUES " +
            "('A','******','a@gmail.com','1') , " +
            "('B','******','b@gmail.com','2') , " +
            "('C','******','c@gmail.com','3') , " +
            "('D','******','d@gmail.com','4') , " +
            "('E','******','e@gmail.com','5')";

    public DBConnectionManager() {
        init();
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void releaseConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void init(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Driver driver = DriverManager.getDriver("jdbc:derby:/db/user-platform;create=true");
            connection = driver.connect("jdbc:derby:/db/user-platform;create=true", new Properties());

//            String databaseURL = "jdbc:derby:/db/user-platform;create=true";
//            connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            try {
                // 删除 users 表
                System.out.println(statement.execute(DROP_USERS_TABLE_DDL_SQL)); // false
            } catch (Throwable throwable) {
                logger.log(Level.SEVERE, throwable.getMessage());
            }
            // 创建 users 表
            System.out.println(statement.execute(CREATE_USERS_TABLE_DDL_SQL)); // false
//            System.out.println(statement.executeUpdate(INSERT_USER_DML_SQL));  // 5
        } catch (Throwable throwable) {
            logger.log(Level.SEVERE, throwable.getMessage());
        }
    }
}
