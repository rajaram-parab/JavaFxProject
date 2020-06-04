package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {

  @FXML
  private WebView webView;

  private WebEngine engine;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub
    engine = webView.getEngine();
  }

  public void buttonAction1(ActionEvent event) {
    engine.load("https://www.google.com");
  }

  public void buttonAction2(ActionEvent event) {
    engine.executeScript("window.location = \"http://easyonlineconverter.com//\";");
  }

  public void buttonAction3(ActionEvent event) {
    engine.loadContent("<html><body><h1>Hello World</h1></body></html>");
  }

  public void buttonAction4(ActionEvent event) {
    engine.reload();

  }

}
