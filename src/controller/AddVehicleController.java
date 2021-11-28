package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InParking;
import model.SlotSeen;
import model.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Date;

import static controller.DashBoardFormController.*;

public class AddVehicleController {
    static int countBus=0;
    static int countVan=0;
    static int countLorry=0;
    public JFXTextField vehicleNumberContext;
    public JFXTextField noOfPassengersContext;
    public JFXComboBox <String>vehicleTypeContext;
    public JFXTextField maximumWeightContext;

    public AnchorPane addVehicleContext;
    public int searchAvailabilityBus(){
        for (Vehicle v : vehiclesDetails) {
            if(v.getVType().equals("Bus")){
                countBus++;
            }
        }
        return countBus;
    }
    public int searchAvailabilityVan(){
        for (Vehicle v : vehiclesDetails) {
            if(v.getVType().equals("Van")){
                countVan++;
            }
        }
        return countVan;
    }
    public int searchAvailabilityLorry(){
        for (Vehicle v : vehiclesDetails) {
            if(v.getVType().equals("Cargo Lorry")){
                countLorry++;
            }
        }
        return countLorry;
    }

    public void saveVehicleOnAction(ActionEvent actionEvent) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
        Date date = new Date();
        String dateAndTime = formatter.format(date);
       if (!vehicleNumberContext.getText().equals(vehiclesDetails)){
        try {
            if (!vehicleNumberContext.getText().equals("") && !maximumWeightContext.getText().equals("") && !noOfPassengersContext.getText().equals("") && !vehicleTypeContext.getSelectionModel().getSelectedItem().equals("null")) {
                Vehicle vehicle = new Vehicle(vehicleNumberContext.getText(), vehicleTypeContext.getSelectionModel().getSelectedItem(), Integer.parseInt(maximumWeightContext.getText()), Integer.parseInt(noOfPassengersContext.getText()));
                try {
                    if (vehicleTypeContext.getSelectionModel().getSelectedItem().equals("Van")) {
                        int vanCount = searchAvailabilityVan();
                        if (vanCount < 6) {
                            if (vehiclesDetails.add(vehicle)) {
                                if (vehicleTypeContext.getSelectionModel().getSelectedItem().equalsIgnoreCase("Van")) {
                                    for (SlotSeen s : vanSlot) {
                                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                                            s.setVehicleNumber(vehicleNumberContext.getText());

                                            InParking parkedVehicle1 = new InParking(vehicleNumberContext.getText(), vehicleTypeContext.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            inParking.add(parkedVehicle1);
                                            countVan =0;
                                            break;
                                        }
                                    }
                                }
                                vehicleNumberContext.clear();
                                maximumWeightContext.clear();
                                noOfPassengersContext.clear();
                                vehicleTypeContext.getItems().clear();
                                initialize();


                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Van Parking is full... ", ButtonType.OK).show();
                        }
                    }
                    if (vehicleTypeContext.getSelectionModel().getSelectedItem().equals("Bus")) {
                        int busCount = searchAvailabilityBus();
                        if (busCount == 0) {
                            if (vehiclesDetails.add(vehicle)) {
                                if (vehicleTypeContext.getSelectionModel().getSelectedItem().equalsIgnoreCase("Bus")) {
                                    for (SlotSeen s : busSlot) {
                                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                                            s.setVehicleNumber(vehicleNumberContext.getText());

                                            InParking parkedVehicle2 = new InParking(vehicleNumberContext.getText(), vehicleTypeContext.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            inParking.add(parkedVehicle2);
                                            break;
                                        }
                                    }
                                }
                                vehicleNumberContext.clear();
                                maximumWeightContext.clear();
                                noOfPassengersContext.clear();
                                vehicleTypeContext.getItems().clear();
                                initialize();

                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Bus Parking is full... ", ButtonType.OK).show();
                        }
                    }
                    if (vehicleTypeContext.getSelectionModel().getSelectedItem().equals("Cargo Lorry")) {
                        int lorryCount = searchAvailabilityLorry();
                        if (lorryCount < 7) {
                            if (vehiclesDetails.add(vehicle)) {
                                if (vehicleTypeContext.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cargo Lorry")) {
                                    for (SlotSeen s : cargoLorrySlot) {
                                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                                            s.setVehicleNumber(vehicleNumberContext.getText());

                                            InParking parkedVehicle3 = new InParking(vehicleNumberContext.getText(), vehicleTypeContext.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            inParking.add(parkedVehicle3);
                                            countLorry=0;
                                            break;
                                        }
                                    }
                                }
                                vehicleNumberContext.clear();
                                maximumWeightContext.clear();
                                noOfPassengersContext.clear();
                                vehicleTypeContext.getItems().clear();
                                initialize();


                            }
                        }else{
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Cargo Lorry Parking is full... ", ButtonType.OK).show();
                        }
                    }
                } catch (Exception e) {}
            } else {

            }
        } catch (Exception e) {

        }

        }else {

           new Alert(Alert.AlertType.WARNING, "Vehicle already exists.... ", ButtonType.OK).show();
       } Stage stage = (Stage) addVehicleContext.getScene().getWindow();
        stage.close();
    }
    public void initialize() {

        vehicleTypeContext.getItems().addAll("Bus","Van","Cargo Lorry");
    }

}
