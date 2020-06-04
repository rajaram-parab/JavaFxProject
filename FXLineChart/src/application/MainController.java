package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class MainController {
  @FXML
  private LineChart<String, Number> lineChart;

  @FXML
  private Label lbl;

  public void btn1(ActionEvent event) {
    lineChart.getData().clear();
    XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
    series.getData().add(new XYChart.Data<String, Number>("Jan", 2000));
    series.getData().add(new XYChart.Data<String, Number>("Feb", 5000));
    series.getData().add(new XYChart.Data<String, Number>("Mar", 3000));
    series.getData().add(new XYChart.Data<String, Number>("Apr", 1000));
    series.setName("Pay Year 2001");
    //
    // XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
    // series1.getData().add(new XYChart.Data<String, Number>("Jan", 3000));
    // series1.getData().add(new XYChart.Data<String, Number>("Feb", 7000));
    // series1.getData().add(new XYChart.Data<String, Number>("Mar", 6000));
    // series1.getData().add(new XYChart.Data<String, Number>("Apr", 4000));
    // series1.setName("Pay Year 2001");
    //
    // XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
    // series2.getData().add(new XYChart.Data<String, Number>("Jan", 5000));
    // series2.getData().add(new XYChart.Data<String, Number>("Feb", 6000));
    // series2.getData().add(new XYChart.Data<String, Number>("Mar", 8000));
    // series2.getData().add(new XYChart.Data<String, Number>("Apr", 6000));
    // series2.setName("Pay Year 2002");

    // lineChart.getData().addAll(series, series1, series2);
    lineChart.getData().add(series);

    for (final XYChart.Data<String, Number> data : series.getData()) {

      data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
          // TODO Auto-generated method stub
          lbl.setText("X :" + data.getXValue() + "\n Y: " + String.valueOf(data.getYValue()));
          Tooltip.install(data.getNode(),
              new Tooltip("X :" + data.getXValue() + "\n Y: " + String.valueOf(data.getYValue())));
        }

      });

    }
  }

}
