package Controllers;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import DBConnection.DBHandler;

public class SingupController implements Initializable{


    @FXML
    private AnchorPane parentPane;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private TextField location;

    @FXML
    private Button singup;

    @FXML
    private ImageView progress;

    @FXML
    private Button login;


    private DBHandler handler;
    private PreparedStatement pst;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        progress.setVisible(false);
      //  name.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
        location.setStyle("-fx-text-inner-color: #a0a2ab;");

        handler = new DBHandler();

    }


    @FXML
    public void singUP(ActionEvent actionEvent) {

        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(even ->
                System.out.println("SingUP Successfully")
        );

        pt.play();

        //Saving Data

        String insert = "INSERT INTO youtubers(names,password,gender,location)"
                + "VALUES (?,?,?,?)";

        Connection connection = handler.getConnection();
        try {
            pst = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
        pst.setString(1, name.getText());
        pst.setString(2, password.getText());
        pst.setString(3, getGender());
        pst.setString(4, location.getText());

        pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    @FXML
    public void loginAction(ActionEvent actionEvent) throws IOException {
        login.getScene().getWindow().hide();

        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/LoginMain.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.initStyle(StageStyle.DECORATED);
        login.show();
        login.setResizable(false);

    }

    private String getGender() {
        String gen ="";

        if (male.isSelected()) {
            gen = "Male";
        }
        else if (female.isSelected()){
            gen = "Female";
        }

        return gen;

    }

}
