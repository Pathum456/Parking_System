package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static controller.DashBoardFormController.vehiclesDetails;


public class VehicleTableFormController {
    public TableView tableVehiclesContext;
    public TableColumn vehicleNoContext;
    public TableColumn vehicleTypeContext;
    public TableColumn maximumWeightContext;
    public TableColumn NoOfPassengersContext;
    public AnchorPane vehicleTableContext;


    public void deleteVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage)vehicleTableContext.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DeleteVehicleForm.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void modifyVehicleOnAction(ActionEvent actionEvent) throws IOException {

    }

    public void closeVehicleWindowOnAction(ActionEvent actionEvent) {
        Stage stage= (Stage)vehicleTableContext.getScene().getWindow();
        stage.close();
    }
    public void initialize(){
        vehicleNoContext.setCellValueFactory(new PropertyValueFactory("VNum"));
        vehicleTypeContext.setCellValueFactory(new PropertyValueFactory("VType"));
        maximumWeightContext.setCellValueFactory(new PropertyValueFactory("VMaximumWeight"));
        NoOfPassengersContext.setCellValueFactory(new PropertyValueFactory("VNumOfPassengers"));

        tableVehiclesContext.setItems(FXCollections.observableArrayList(vehiclesDetails));

    }
}
