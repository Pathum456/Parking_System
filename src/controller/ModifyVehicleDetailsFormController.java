package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Vehicle;

import static controller.DashBoardFormController.vehiclesDetails;

public class ModifyVehicleDetailsFormController {
    public JFXTextField searchVehicleNumberTxt;
    public JFXTextField maximumNewWeightContext;
    public JFXTextField noOfNewPassengersContext;

    public JFXTextField vehicleNewNumberContext;
    public JFXComboBox vehicleNewTypeContext;
    public AnchorPane modifyVehicleContext;

    public void modifyVehicleOnAction(ActionEvent actionEvent) {
        int count=0;
        try{
            for (Vehicle v: vehiclesDetails) {
                if (searchVehicleNumberTxt.getText().equalsIgnoreCase(v.getVNum())) {
                    v.setVNum(vehicleNewNumberContext.getText());
                    //v.setVType(vehicleNewTypeContext.getSelectionModel());
                   // v.setVMaximumWeight(maximumNewWeightContext.getText());
                    //v.setVNumOfPassengers(noOfNewPassengersContext.getText());

                    count = 1;
                    Stage stage= (Stage)modifyVehicleContext.getScene().getWindow();
                    stage.close();
                    break;
                } else if (!searchVehicleNumberTxt.getText().equalsIgnoreCase(v.getVNum())) {
                    count = -1;
                }
            }
        }catch (Exception e){}
        finally{
            if (count==1){
                new Alert(Alert.AlertType.CONFIRMATION,"Driver Details Update SuccessFully....", ButtonType.OK).show();

            }else if (count==-1){
                new Alert(Alert.AlertType.WARNING,"driver NIC Does not exists...Please try again.",ButtonType.OK).show();
            }
        }
    }
}
