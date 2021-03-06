package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class MainController implements Initializable {

  final MyNumber myNum = new MyNumber();

  @FXML
  private Label lblStatus;

  @FXML
  private ProgressBar pb;

  @FXML
  private ProgressIndicator pi;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    myNum.setNumber(0);
    myNum.numberProperty().addListener(new ChangeListener<Object>() {

      @Override
      public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
        System.out.println(arg0.toString());
        System.out.println(arg1.toString());
        System.out.println(arg2.toString());
        lblStatus.setText(new Double(myNum.getNumber()).toString());
        pi.progressProperty().bind(myNum.numberProperty());
        pb.progressProperty().bind(myNum.numberProperty());

      }

    });
  }

  public void onButtonAction(ActionEvent event) {
    myNum.setNumber(myNum.getNumber() + 0.1);
  }

  public void onButton2Action(ActionEvent event) {
    myNum.setNumber(myNum.getNumber() - 0.1);
  }

}
