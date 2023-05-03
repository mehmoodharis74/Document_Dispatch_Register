package com.example.application_dispatcher.dbConnection;


import com.example.application_dispatcher.Constant.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlConnector {
    String url = "jdbc:mysql://localhost:3306/dispatchRegister";
    String user = "root";
    String password = "root123";
    Connection connection;

    public MySqlConnector(Connection connection) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        String use_DB = "use" + " " + Constants.DATABASE_NAME;
        PreparedStatement st = connection.prepareStatement(use_DB);
        st.executeUpdate(use_DB);
        this.connection = connection;
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }

}
