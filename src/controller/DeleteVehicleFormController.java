package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InParking;
import model.OnDelivery;
import model.Vehicle;

import static controller.DashBoardFormController.*;

public class DeleteVehicleFormController {
    public AnchorPane deleteVehicleContext;
    public JFXTextField deleteVehicleTxt;

    public void deleteVehicleOnAction(ActionEvent actionEvent) {
        int count=0;
        try {
            for (Vehicle v : vehiclesDetails) {
                if (deleteVehicleTxt.getText().equalsIgnoreCase(v.getVNum())){
                    vehiclesDetails.remove(v);
                    count=1;
                    break;
                }else if(!deleteVehicleTxt.getText().equalsIgnoreCase(v.getVNum())){
                    count=-1;
                }
            }
            for(OnDelivery d : onDelivery){
                if(deleteVehicleTxt.getText().equalsIgnoreCase(d.getVehicleNumber())){
                    onDelivery.remove(d);
                    break;
                }
            }
            for(InParking p : inParking){
                if(deleteVehicleTxt.getText().equalsIgnoreCase(p.getVehicleNumber())){
                    inParking.remove(p);
                    break;
                }
            }
            //pageRefresh();
        }catch (Exception e){}
        finally {
            if(count==1){
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle details Deleted successfully", ButtonType.OK).show();
            }else if (count==-1){
                new Alert(Alert.AlertType.WARNING, "Vehicle Number Does not exists..Please try again..!", ButtonType.OK).show();
            }
        }
        Stage stage = (Stage) deleteVehicleContext.getScene().getWindow();
        stage.close();
    }
}
