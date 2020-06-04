package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainController implements Initializable {

  @FXML
  private MediaView mv;
  private MediaPlayer mp;
  private Media me;
  private Slider volumeSlider;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    String path = new File("src/media/Apktool.mp4").getAbsolutePath();
    me = new Media(new File(path).toURI().toString());
    mp = new MediaPlayer(me);
    mv.setMediaPlayer(mp);
    // mp.setAutoPlay(true);

    DoubleProperty width = mv.fitWidthProperty();
    DoubleProperty height = mv.fitHeightProperty();
    width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
    height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
    // System.out.println(mp.getVolume());
    // volumeSlider.setValue(0); // 0 --> Min Val 1-->Max Val
    // volumeSlider.valueProperty().addListener(new InvalidationListener() {
    //
    // @Override
    // public void invalidated(Observable arg0) {
    // mp.setVolume(volumeSlider.getValue() / 100);
    // }
    //
    // });
  }

  public void play(ActionEvent event) {
    mp.play();
    mp.setRate(1);
  }

  public void pause(ActionEvent event) {
    mp.pause();
  }

  public void fast(ActionEvent event) {
    mp.setRate(2);
  }

  public void slow(ActionEvent event) {
    mp.setRate(.5);
  }

  public void reload(ActionEvent event) {
    mp.seek(mp.getStartTime());
    mp.play();
  }

  public void start(ActionEvent event) {
    mp.seek(mp.getStartTime());
    mp.stop();
  }

  public void last(ActionEvent event) {
    mp.seek(mp.getTotalDuration());
    mp.stop();
  }
}
