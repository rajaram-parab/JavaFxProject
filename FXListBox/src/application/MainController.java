package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainController implements Initializable {

  @FXML
  private ComboBox<String> combobox;

  @FXML
  private Label lblComboText;

  @FXML
  private ListView listview;

  ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "Jack", "John");

  //
  // @Override
  public void initialize(URL location, ResourceBundle resources) {
    // combobox.setItems(list);
    // listview.setItems(list);
  }

  public void comboText(ActionEvent event) {
    // combobox.getItems().addAll("Rex", "Sham", "Vika");
    // lblComboText.setText(combobox.getValue());
  }

  public void buttonAction(ActionEvent event) {
    // listview.getItems().addAll("Rex", "Sham", "Vika");
  }
}
