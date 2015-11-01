package StatementDB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/newmysqldb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "2015";

    public static void main(String[] args) throws SQLException {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();  // подключаем для создания/выполнения статических запросов к БД
            System.out.println(!connection.isClosed()); // true - CONNECTION is NOT CLOSED
            statement.execute("INSERT INTO table_comp (name, price) values ('Mac', 10000);");       // команда-запрос к БД
            statement.executeUpdate("UPDATE table_comp SET name='IPad', price=12000 WHERE id=14;"); // команда-запрос к БД
            statement.executeUpdate("DELETE FROM table_comp WHERE id=14;");                         // команда-запрос к БД
            statement.executeUpdate("UPDATE table_comp SET name='Mac', price=10000 WHERE id=13; "); // команда-запрос к БД
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
