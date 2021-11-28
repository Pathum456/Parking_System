package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginInFormController {
    public AnchorPane backContext;
    public JFXPasswordField passwordContext;
    public JFXTextField userNameTxt;


    public void goBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage)backContext.getScene().getWindow();
        stage.close();
        DashBoardFormController.count=0;


    }


    public void goLogInOnAction(ActionEvent actionEvent) throws IOException {

       // if ( userNameTxt.getText().equals("Saman")&&passwordContext.getText().equals("saman")) {


            Stage stage = (Stage) backContext.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManagerWorkForm.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            stage = new Stage();
            stage.setScene(scene);
            stage.show();
            DashBoardFormController.count--;
        /*}else if (!passwordContext.getText().equals("saman")){
            new Alert(Alert.AlertType.CONFIRMATION, "Password Incorrect..try again.", ButtonType.OK).show();
        }*/
    }


    public void gotToLoginButton(ActionEvent actionEvent) throws IOException {
        goLogInOnAction(actionEvent);
    }

    public void goToPasswordPield(ActionEvent actionEvent) {
        passwordContext.requestFocus();
    }
}
