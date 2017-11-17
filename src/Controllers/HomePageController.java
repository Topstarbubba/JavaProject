package Controllers;

import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{


    @FXML
    private AnchorPane anchor;

    @FXML
    private HBox toolBarRight;

    @FXML
    private Label lblMenu;

    @FXML
    private VBox overflowContainer;

    @FXML
    private AnchorPane holderPane;

    @FXML
    private AnchorPane home;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

          createPage();

    }

    private void setNode(Node node){

        holderPane.getChildren().clear();
        holderPane.getChildren().add(node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();

    }


    private void createPage() {

        try {
            home = FXMLLoader.load(getClass().getResource("../FXML/Home.fxml"));

            setNode(home);

        } catch (IOException ef) {
            ef.printStackTrace();
        }
    }
}
