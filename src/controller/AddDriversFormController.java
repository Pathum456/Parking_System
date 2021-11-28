package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import static controller.DashBoardFormController.driversDetails;


public class AddDriversFormController {


    public AnchorPane driverContext;
    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;

    public void addDriverOnAction(ActionEvent actionEvent) {
        //for (Driver r : driversDetails){
           // if (!txtNIC.getText().equals(r.getNIC())){
                try {
                    Driver driver = new Driver(txtDriverName.getText(), txtNIC.getText(), txtDrivingLicenseNo.getText(), txtAddress.getText(), txtContactNo.getText());
                    if (driversDetails.add(driver) || txtDriverName.getLength() != 0) {
                        //InParking parkedVehicle =new InParking()
                        txtDriverName.clear();

                        txtNIC.clear();
                        txtDrivingLicenseNo.clear();
                        txtAddress.clear();
                        txtContactNo.clear();
                        System.out.println(driversDetails.toString());
                        new Alert(Alert.AlertType.CONFIRMATION, "Driver details saved successfully", ButtonType.OK).show();

                    }
                } catch (NumberFormatException e) {

                    new Alert(Alert.AlertType.WARNING, "Please, Fill all data and try again..!", ButtonType.CLOSE).show();


                }
                Stage stage = (Stage) driverContext.getScene().getWindow();
                stage.close();
                // }else{ new Alert(Alert.AlertType.WARNING, "Driver Already exists....", ButtonType.CLOSE).show();
                //}

           // }else{ new Alert(Alert.AlertType.WARNING, "Driver Already exists....", ButtonType.CLOSE).show();}
       // }

    }
        //if (txtNIC.getText().equalsIgnoreCase(String.valueOf(driversDetails))) {

}
