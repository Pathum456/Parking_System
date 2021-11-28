package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ManagerWorkFormController {
    public AnchorPane managerContext;
    public JFXComboBox selectContext;
    public AnchorPane getWindowContext;
    public static ArrayList<String> comboselect = new ArrayList<>();
    static {
        comboselect.add("In Parking");
        comboselect.add("On Delivery");
    }
    public void initialize() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String temp1 : comboselect
        ) {
            obList.add(temp1);
        }
        selectContext.setItems(obList);
    }

    public void selectOnAction(ActionEvent actionEvent) throws IOException {
        if(selectContext.getValue().equals("In Parking")){
            URL resource = getClass().getResource("../view/TableViewInParking.fxml");
            Parent load = FXMLLoader.load(resource);
            getWindowContext.getChildren().clear();
            getWindowContext.getChildren().add(load);
        }else if(selectContext.getValue().equals("On Delivery")) {

            URL resource = getClass().getResource("../view/OnDeliveryForm.fxml");
            Parent load = FXMLLoader.load(resource);
            getWindowContext.getChildren().clear();
            getWindowContext.getChildren().add(load);
        }

    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddVehicle.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddDriversForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage)managerContext.getScene().getWindow();
        stage.close();
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DashBoardForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();*/
    }



    public void vehicleVehicleOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VehicleTableForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void detailsDriverOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DriverTableViewForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
