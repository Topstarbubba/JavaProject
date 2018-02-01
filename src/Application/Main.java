package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
      try {
          Parent root = FXMLLoader.load(getClass().getResource("../FXML/LoginMain.fxml"))
                  ;
          primaryStage.setTitle("JavaFX");

          primaryStage.setScene(new Scene(root, 600, 400));
          primaryStage.initStyle(StageStyle.DECORATED);
          primaryStage.show();
          primaryStage.setResizable(false);
      } catch (Exception e) {
          e.printStackTrace();
      }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
