package main.java.com.magdezis.loginmagdezis.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConenction{
    //atributos
    private static Connection connection;
    /* constructor
    el constructor tiene que ser privado porque No permite que
    la clase sea instanciada
    */
    private DataBaseConenction(){};
    // metodo
    public static Connection getDataBaseConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(
                 Credentials.URL_DATA_BASE, 
                 Credentials.USER_DB,
                 Credentials.PASS_DB);
        }
        return connection;
    }
}