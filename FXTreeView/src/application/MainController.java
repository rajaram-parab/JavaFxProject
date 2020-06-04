package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

  @FXML
  TreeView<String> treeview;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // <a href="https://icons8.com/icon/118962/folder">Folder icon by Icons8</a>
    Image img = new Image(getClass().getResourceAsStream("/img/folderIcon.png"));
    TreeItem<String> root = new TreeItem<>("Root", new ImageView(img));
    root.setExpanded(true);

    TreeItem<String> nodeA = new TreeItem<>("node A", new ImageView(img));
    TreeItem<String> nodeB = new TreeItem<>("node B", new ImageView(img));
    TreeItem<String> nodeC = new TreeItem<>("node C", new ImageView(img));

    // root.getChildren().add(nodeA);
    // root.getChildren().add(nodeB);
    // root.getChildren().add(nodeC);

    root.getChildren().addAll(nodeA, nodeB, nodeC, new TreeItem<>("node D"));

    TreeItem<String> nodeA1 = new TreeItem<>("node A1", new ImageView(img));
    TreeItem<String> nodeA2 = new TreeItem<>("node A2", new ImageView(img));
    TreeItem<String> nodeA3 = new TreeItem<>("node A3", new ImageView(img));

    nodeA.getChildren().addAll(nodeA1, nodeA2, nodeA3);

    treeview.setRoot(root);

  }

  public void mouseClickEvent(MouseEvent event) {
    if (event.getClickCount() == 2) {
      TreeItem<String> item = treeview.getSelectionModel().getSelectedItem();
      System.out.println(item.getValue());
    }
  }

}
