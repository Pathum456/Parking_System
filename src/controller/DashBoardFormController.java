package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;




public class DashBoardFormController {
    static int count=0;

    static SlotSeen[] vanSlot={new SlotSeen("null","1"),new SlotSeen("null","2"),new SlotSeen("null","3"),new SlotSeen("null","4"),new SlotSeen("null","13"),new SlotSeen("null","12")};
    static SlotSeen[] busSlot={new SlotSeen("null","14")};
    static SlotSeen[] cargoLorrySlot={new SlotSeen("null","5"),new SlotSeen("null","6"),new SlotSeen("null","7"),new SlotSeen("null","8"),new SlotSeen("null","9"),new SlotSeen("null","10"),new SlotSeen("null","11")};
    static ArrayList<Driver> driversDetails=new ArrayList();
    static ArrayList<Vehicle> vehiclesDetails=new ArrayList();
    static ArrayList<OnDelivery> onDelivery=new ArrayList();
    static ArrayList<InParking> inParking=new ArrayList();
    static ArrayList<DriverSearch> driverSearch=new ArrayList();
    public AnchorPane homeCheckContext;
    public ComboBox<String> cmbSelectVehicleContext;
    public ComboBox<String> driverContext;

    String vehicleNumber;
    public TextField dateTimeContext;
    public TextField dateContext;
    public JFXButton oneClickContext;

    public JFXTextField slotTxt;
    public JFXTextField textContext;
    public JFXButton parkedVehicle;
    public JFXButton deliveryVehicle;

    public void initialize() {
        dateTimeContext.setEditable(false);
        dateContext.setEditable(false);


        try {
            new Timer(1000, e -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
                String displayTime = simpleDateFormat.format(new Date());
                String displayDate = new SimpleDateFormat("yyyy/MMM/dd", Locale.ENGLISH).format(new Date());

                dateContext.setText(displayDate);
                dateTimeContext.setText(displayTime);
            }).start();
        }catch (Exception e){}



        cmbSelectVehicleContext.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            slotTxt.setText("");
            try {
                for (Vehicle v : vehiclesDetails) {
                    if (newValue.equalsIgnoreCase(v.getVNum())) {
                        textContext.setText( v.getVType());

                        vehicleNumber = v.getVNum();
                        if (inParking.size() == 0) {
                            parkedVehicle.setDisable(false);
                            deliveryVehicle.setDisable(true);
                            for (DriverSearch s : driverSearch) {
                                if (cmbSelectVehicleContext.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())) {
                                    driverContext.setValue(s.getDriverName());
                                    driverContext.setDisable(true);
                                    break;
                                }
                            }
                        } else {
                            setDisable(newValue);
                        }
                    }
                }
            } catch (Exception ex) {
            }
        });


        for (Vehicle v: vehiclesDetails) {
            cmbSelectVehicleContext.getItems().add(v.getVNum());
        }for (Driver d: driversDetails) {
            driverContext.getItems().add(d.getName());
        }
    }



    public void managmentLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(count==0) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LogInForm.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            count++;
            oneClickContext.setDisable(false);


        }else{ oneClickContext.setDisable(true);}
    }


    public void refreshOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        homeCheckContext.getChildren().clear();
        homeCheckContext.getChildren().add(load);
    }


    public void setDisable(String vehicleNumber){
        for (InParking p : inParking) {
            if (p.getVehicleNumber().equals(vehicleNumber)) {
                driverContext.setDisable(false);
                parkedVehicle.setDisable(true);
                driverContext.setDisable(false);

                break;
            }else{
                for (DriverSearch s :driverSearch) {
                    if(cmbSelectVehicleContext.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())){
                        driverContext.setValue(s.getDriverName());
                        driverContext.setDisable(true);
                        break;
                    }
                }
                parkedVehicle.setDisable(false);
                deliveryVehicle.setDisable(true);
            }
        }
    }

    public void parkingSlotOnAction(ActionEvent actionEvent) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
        Date date = new Date();
        String dateAndTime = formatter.format(date);
        for (OnDelivery d : onDelivery) {

            if (d.getVehicleNumber().equals(cmbSelectVehicleContext.getSelectionModel().getSelectedItem())) {
                onDelivery.remove(d);


                if (textContext.getText().equalsIgnoreCase("Van")) {
                    for (SlotSeen s : vanSlot) {
                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                            System.out.println("B");
                            String slotNumber = s.getSlotNumber();
                            slotTxt.setText(slotNumber);
                            //System.out.println(slotNumber);

                            InParking inParking1 = new InParking(cmbSelectVehicleContext.getSelectionModel().getSelectedItem(), textContext.getText(), slotNumber, dateAndTime);
                            inParking.add(inParking1);
                            System.out.println(inParking.toString());
                            s.setVehicleNumber(cmbSelectVehicleContext.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }
                if (textContext.getText().equalsIgnoreCase("Bus")) {
                    for (SlotSeen s : busSlot) {
                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            slotTxt.setText(slotNumber);

                            InParking inParking1 = new InParking(cmbSelectVehicleContext.getSelectionModel().getSelectedItem(), textContext.getText(), slotNumber, dateAndTime);
                            inParking.add(inParking1);
                            System.out.println(inParking.toString());
                            s.setVehicleNumber(cmbSelectVehicleContext.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }

                if (textContext.getText().equalsIgnoreCase("Cargo Lorry")) {
                    for (SlotSeen s : cargoLorrySlot) {
                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            slotTxt.setText(slotNumber);

                            InParking inParking1 = new InParking(cmbSelectVehicleContext.getSelectionModel().getSelectedItem(), textContext.getText(), slotNumber, dateAndTime);
                            inParking.add(inParking1);
                            System.out.println(inParking.toString());
                            s.setVehicleNumber(cmbSelectVehicleContext.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }

            }


        }
    }


        public void deliveryOnAction (ActionEvent actionEvent) throws IOException {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
                Date date = new Date();
                String dateAndTime = formatter.format(date);
                if (!cmbSelectVehicleContext.getSelectionModel().getSelectedItem().equals("null") && !driverContext.getSelectionModel().getSelectedItem().equals("null")) {
                    System.out.println("A");
                    for (InParking p : inParking) {
                        System.out.println("B");
                        if (p.getVehicleNumber().equalsIgnoreCase(cmbSelectVehicleContext.getSelectionModel().getSelectedItem())) {
                            inParking.remove(p);
                            System.out.println("C");
                            OnDelivery onDelivery1 = new OnDelivery(cmbSelectVehicleContext.getSelectionModel().getSelectedItem(), textContext.getText(), driverContext.getSelectionModel().getSelectedItem(), dateAndTime);
                            onDelivery.add(onDelivery1);

                            //driversearch object ekak hadala array ekata add karano
                            DriverSearch driverSearch1 = new DriverSearch(cmbSelectVehicleContext.getSelectionModel().getSelectedItem(), driverContext.getSelectionModel().getSelectedItem());
                            driverSearch.add(driverSearch1);
                            if (textContext.getText().equalsIgnoreCase("Van")) {
                                for (SlotSeen s : vanSlot) {
                                    if (cmbSelectVehicleContext.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())) {
                                        s.setVehicleNumber("null");
                                    }
                                }
                            }
                            if (textContext.getText().equalsIgnoreCase("Bus")) {
                                for (SlotSeen s : busSlot) {
                                    if (cmbSelectVehicleContext.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())) {
                                        s.setVehicleNumber("null");
                                    }
                                }
                            }
                            if (textContext.getText().equalsIgnoreCase("Cargo Lorry")) {
                                for (SlotSeen s : cargoLorrySlot) {
                                    if (cmbSelectVehicleContext.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())) {
                                        s.setVehicleNumber("null");
                                    }
                                }
                            }
                            System.out.println(onDelivery.toString());

                            URL resource = getClass().getResource("../view/DashBoardForm.fxml");

                            Parent load = FXMLLoader.load(resource);

                            homeCheckContext.getChildren().clear();
                            homeCheckContext.getChildren().add(load);
                            new Alert(Alert.AlertType.CONFIRMATION, "You can Deliver now..", ButtonType.OK).show();
                            break;
                        }
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Please fill all fields and try again...", ButtonType.CLOSE).show();
                }
            } catch (Exception e) {
            }
            URL resource = getClass().getResource("../view/DashBoardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            homeCheckContext.getChildren().clear();
            homeCheckContext.getChildren().add(load);
        }

}
