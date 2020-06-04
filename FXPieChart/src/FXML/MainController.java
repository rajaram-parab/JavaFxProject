package FXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {

  @FXML
  private PieChart piechart;

  @FXML
  private Label status;

  public void btn1(ActionEvent event) {
    ObservableList<Data> list = FXCollections.observableArrayList(new PieChart.Data("Java", 50),
        new PieChart.Data("c++", 20), new PieChart.Data("Python", 60), new PieChart.Data("c#", 10),
        new PieChart.Data("c", 15));
    piechart.setData(list);

    for (final PieChart.Data data : piechart.getData()) {
      data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent arg0) {
          // TODO Auto-generated method stub
          status.setText(String.valueOf(data.getPieValue()) + " %");
        }

      });
    }
  }

}
