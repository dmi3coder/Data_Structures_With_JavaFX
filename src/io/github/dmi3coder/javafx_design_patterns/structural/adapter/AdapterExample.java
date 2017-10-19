package io.github.dmi3coder.javafx_design_patterns.structural.adapter;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdapterExample extends Application {

  private List<String> listType = Arrays.asList(
      "Stuff", "Department"
  );
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root));
    ListView listView = ((ListView) root.lookup("#list"));
    ComboBox spinner = (ComboBox) root.lookup("#spinner");
    spinner.setItems(FXCollections.observableArrayList(listType));
    spinner.setOnAction(event -> {
      int position = listType.indexOf(spinner.getValue());
      listView.setCellFactory(param -> new StuffCell());
      listView.setItems(FXCollections.observableList(Arrays.asList(new Stuff("dmi3coder","dsdasd",null))));

    });
    primaryStage.show();
  }
}
