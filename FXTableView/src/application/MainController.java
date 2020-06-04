package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {

  @FXML
  private TableView<Student> table;

  @FXML
  private TableColumn<Student, Integer> id;
  @FXML
  private TableColumn<Student, String> name;
  @FXML
  private TableColumn<Student, String> surname;
  @FXML
  private TableColumn<Student, Integer> age;

  public ObservableList<Student> list = FXCollections.observableArrayList(
      new Student(1, "Mark", "Spoon", 22), new Student(2, "Anna", "Hope", 25),
      new Student(3, "Tom", "Cruise", 24), new Student(4, "Jack", "Job", 27),
      new Student(5, "Jonny", "Cash", 28));

  @Override
  public void initialize(URL Location, ResourceBundle resources) {
    id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
    name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
    surname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
    age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
    table.setItems(list);
  }

}
