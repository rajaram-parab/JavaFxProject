package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

  @FXML
  private Label result;
  private long number1 = 0;
  private String operator = "";
  private boolean start = true;

  public void processNumber(ActionEvent event) {
    if (start) {
      result.setText("");
      start = false;
    }
    String value = ((Button) event.getSource()).getText();
    result.setText(result.getText() + value);

  }

  public void processOperator(ActionEvent event) {
    String value = ((Button) event.getSource()).getText();
    Model model = new Model();

    if (!value.equals("=")) {
      if (!operator.isEmpty()) {
        return;
      }
      operator = value;
      number1 = Long.parseLong(result.getText());
      result.setText("");
    } else {
      long number2 = Long.parseLong(result.getText());
      float output = model.calculate(number1, number2, operator);
      result.setText(String.valueOf(output));
      start = true;
    }
  }

}
