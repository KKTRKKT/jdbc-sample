package me.kktrkkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:15432/postgres";
        String username = "kktrkkt";
        String password = "pass";

        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println(connection);
            final String ddl = "CREATE TABLE ACCOUNT (id int, username VARCHAR(255), password VARCHAR(255));";
            excuteSql(connection, ddl);
            final String dml = "INSERT INTO ACCOUNT VALUES(1, 'kktrkkt', 'pass');";
            excuteSql(connection, dml);
        }
    }

    private static void excuteSql(Connection connection, String ddl) throws SQLException {
        try (final PreparedStatement preparedStatement = connection.prepareStatement(ddl)) {
            preparedStatement.execute();
        }
    }
}
