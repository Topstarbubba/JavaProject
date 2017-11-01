package Controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{

    @FXML
    AnchorPane holderPane;

    @FXML
    AnchorPane home;




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
