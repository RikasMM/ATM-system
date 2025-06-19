package bank.management.system;

import java.sql.*;

public class Connn {
    public Connection connection;
    public Statement statement;

    public Connn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem?useSSL=false&serverTimezone=UTC",
                    "root",
                    ""
            );
            statement = connection.createStatement();
            System.out.println("DB Connected");
        } catch (Exception e) {
            System.out.println("DB Connection Failed");
            e.printStackTrace();
        }
    }
}
