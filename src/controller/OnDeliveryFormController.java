package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static controller.DashBoardFormController.onDelivery;

public class OnDeliveryFormController {


    public TableView onDeliveryTableView;
    public TableColumn deliveryVehicleNum;
    public TableColumn deliveryVehicleType;
    public TableColumn deliveryVehicleDriver;
    public TableColumn deliveryTime;




    public void initialize() {
        deliveryVehicleNum.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        deliveryVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        deliveryVehicleDriver.setCellValueFactory(new PropertyValueFactory("driverName"));
        deliveryTime.setCellValueFactory(new PropertyValueFactory("leftTime"));


        onDeliveryTableView.setItems(FXCollections.observableArrayList(onDelivery));
    }
}
