package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs{

    private Connection dbconnection;

    public Connection getConnection() {

        String connectionSting = "jdbc:mysql://" + Configs.dbhost + ":" + Configs.dbport + "/" + Configs.dbname + "?autoReconnect-true&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
        dbconnection = DriverManager.getConnection(connectionSting,Configs.dbuser,Configs.dbpass);
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return dbconnection;

    }
}
