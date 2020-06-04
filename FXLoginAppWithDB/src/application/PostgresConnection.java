package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnection {

  public static Connection Connector() {
    try {
      Class.forName("org.postgresql.Driver");
      Connection connection = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/Employeedb", "tad", "tad");
      return connection;
    } catch (Exception e) {
      return null;
      // TODO: handle exception
    }

  }

}
