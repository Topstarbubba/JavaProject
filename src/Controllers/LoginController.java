package Controllers;

import com.mysql.jdbc.PreparedStatement;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import DBConnection.DBHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button singup;

    @FXML
    private CheckBox remember;

    @FXML
    private Button forgotpassword;

    @FXML
    private ImageView progress;

    private DBHandler handler;
    private Connection connection;
    private PreparedStatement pst;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");

        handler = new DBHandler();

    }

    @FXML
    public void loginAction(ActionEvent actionEvent) {

        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(1));
        pt.setOnFinished(even -> {

            System.out.println("Login Successfully");

            //Retrive Data from DataBase;

            connection = handler.getConnection();
            String q1 = "SELECT * from youtubers where names=? and password=?";

            try {
                pst = (PreparedStatement) connection.prepareStatement(q1);

                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                ResultSet rs = pst.executeQuery();

                int count = 0;

                while (rs.next()){

                    count=count+1;
                }

                if (count==1){

                    //  System.out.println("Login Successful");

                    login.getScene().getWindow().hide();

                    Stage home = new Stage();
                    try {

                        Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
                        Scene scene = new Scene(root);
                        home.setScene(scene);
                        home.initStyle(StageStyle.DECORATED);
                        home.show();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                }
                else {

                     System.out.println("Username or Password is not Correct");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Username or Password is not Correct");
                    alert.show();
                    progress.setVisible(false);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });

        pt.play();

    }

    @FXML
    public void singUP(ActionEvent actionEvent) throws IOException {

        login.getScene().getWindow().hide();

        Stage singup = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("../FXML/SingUP.fxml"));
        Scene scene = new Scene(root);
        singup.setScene(scene);
        singup.initStyle(StageStyle.DECORATED);
        singup.show();
        singup.setResizable(false);

    }
}