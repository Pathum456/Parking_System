package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import static controller.DashBoardFormController.driversDetails;

public class UpdateDriverDetailsFormController {


    public JFXTextField txtDriverNameUpdate;
    public JFXTextField txtNICSearchDriver;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextField txtAddressUpdate;
    public JFXTextField txtContactNoUpdate;
    public JFXTextField txtNICDriverUpdate;
    public AnchorPane updateDriverContext;

    public void updateDriverOnAction(ActionEvent actionEvent) {
        int count=0;
        try{
            for (Driver d: driversDetails) {
                if (txtNICSearchDriver.getText().equalsIgnoreCase(d.getNIC())) {
                    d.setName(txtDriverNameUpdate.getText());
                    //d.setNIC(txtNICDriverUpdate.getText());
                    d.setLNum(txtDrivingLicenseNo.getText());
                    d.setAddress(txtAddressUpdate.getText());
                    d.setContact(txtContactNoUpdate.getText());
                    count = 1;
                    Stage stage= (Stage)updateDriverContext.getScene().getWindow();
                    stage.close();
                    break;
                } else if (!txtNICSearchDriver.getText().equalsIgnoreCase(d.getNIC())) {
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
