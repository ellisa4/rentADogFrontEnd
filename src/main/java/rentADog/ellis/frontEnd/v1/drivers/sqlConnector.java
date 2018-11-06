package rentADog.ellis.frontEnd.v1.drivers;

import java.sql.*;

public class sqlConnector {
    private String user;
    private String password;
    private String connection_url;
    private Connection conn;

    public sqlConnector()
    {
        user = "spcaAdmin";
        password = "admin123!";
        connection_url ="jdbc:mariadb://localhost/spca";
    }


    public Connection openConnection()
    {
        //openConnection method needs to be called whenever using the database
        //should be first method used
        try {
            conn=DriverManager.getConnection(connection_url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

    public void closeConnection()
    {
        try {
            if(!conn.isClosed())
            {
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
