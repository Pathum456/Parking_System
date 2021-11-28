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

import static controller.DashBoardFormController.driversDetails;

public class DriverTableViewFormController {
    public AnchorPane TableViewFormContext;
    public TableView tblDriverDetails;
    public TableColumn colDName;
    public TableColumn colDNIC;
    public TableColumn colDDrivingLicenseNo;
    public TableColumn colDAddress;
    public TableColumn colDContactNo;


    public void updateOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage)TableViewFormContext.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UpdateDriverDetailsForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
        DashBoardFormController.count--;
    }

    public void deleteOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage)TableViewFormContext.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DeleteDriverForm.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeOnAction(ActionEvent actionEvent) {
        Stage stage= (Stage)TableViewFormContext.getScene().getWindow();
        stage.close();
    }

    public void initialize(){
        colDName.setCellValueFactory(new PropertyValueFactory("Name"));
        colDNIC.setCellValueFactory(new PropertyValueFactory("NIC"));
        colDDrivingLicenseNo.setCellValueFactory(new PropertyValueFactory("LNum"));
        colDAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        colDContactNo.setCellValueFactory(new PropertyValueFactory("Contact"));

        tblDriverDetails.setItems(FXCollections.observableArrayList(driversDetails));
    }
}
