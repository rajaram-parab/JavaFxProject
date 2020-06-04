package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

  @FXML
  private Label myMessage;

  @FXML
  public void randomNumberGenerator(ActionEvent event) {
    Random rand = new Random();
    int myRand = rand.nextInt(50) + 1;
    myMessage.setText(new Integer(myRand).toString());
    // System.out.println(myRand);
  }

}
