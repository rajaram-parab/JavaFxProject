package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController implements Initializable {

  public LoginModel loginModel = new LoginModel();

  @FXML
  private Label isConnected;

  @FXML
  private TextField txtUserName;

  @FXML
  private TextField txtPassword;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub
    try {
      if (loginModel.isDbConnected()) {
        isConnected.setText("Connected");
      } else {
        isConnected.setText("Not  Connected");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Login(ActionEvent event) throws IOException {
    try {
      if (loginModel.isLogin(txtUserName.getText(), txtPassword.getText())) {
        isConnected.setText("UserName and Password is correct");

        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/application/User.fxml").openStream());
        UserController userController = (UserController) loader.getController();
        userController.getUser(txtUserName.getText());
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

      } else {
        isConnected.setText("UserName and Password is not correct");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      isConnected.setText("UserName and Password is not correct");
    }
  }

}
