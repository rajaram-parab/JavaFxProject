package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

  Connection connection;

  public LoginModel() {
    connection = PostgresConnection.Connector();
    if (connection == null) {
      System.exit(1);
    }
  }

  public boolean isDbConnected() throws SQLException {
    return !connection.isClosed();
  }

  public boolean isLogin(String user, String pass) throws SQLException {
    PreparedStatement prepareStatement = null;
    ResultSet resultSet = null;
    String query = "select * from employee where username = ? and password = ?";
    try {
      prepareStatement = connection.prepareStatement(query);
      prepareStatement.setString(1, user);
      prepareStatement.setString(2, pass);

      resultSet = prepareStatement.executeQuery();
      if (resultSet.next()) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
      // TODO: handle exception
    } finally {
      prepareStatement.close();
      resultSet.close();
    }

  }

}
