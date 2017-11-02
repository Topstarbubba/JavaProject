package Controllers;

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



    AnchorPane home;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        JFXRippler rippler = new JFXRippler(lblMenu);
        rippler.setMaskType(JFXRippler.RipperMask.RECT);
        toolBarRight.getChildren().add(rippler);


        openMenus();
        createPage();



    }

    private void openMenus(){

        JFXPopup pop = new JFXPopup();
        pop.setContent(overflowContainer);
        pop.setPopupContainer(anchor);
        pop.setSource(lblmenu);

        lblmenu.setOnMouseClicked(event -> (

                pop.show(JFXPopup.Popup)


                ));
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
