package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;


import static controller.DashBoardFormController.driversDetails;


public class DeleteDriverFormController {
    public AnchorPane deleteDriverContext;
    public JFXTextField deleteDriverTxt;

    public void deleteDriverOnAction(ActionEvent actionEvent) {
        int count=0;
        try {
            for (Driver d : driversDetails) {
                if(deleteDriverTxt.getText().equalsIgnoreCase(d.getNIC())){
                    driversDetails.remove(d);
                    count=1;
                    break;
                }else if(!deleteDriverTxt.getText().equalsIgnoreCase(d.getNIC())){
                    count=-1;
                }
            }
            //pageRefresh();
        }catch (Exception e){}
        finally {
            if (count==1){
                new Alert(Alert.AlertType.CONFIRMATION, "Driver Details Deleted Successfully..!", ButtonType.OK).show();
            }else if (count==-1){
                new Alert(Alert.AlertType.WARNING, "Driver NIC does not exists..!", ButtonType.OK).show();
            }
        }
        Stage stage = (Stage) deleteDriverContext.getScene().getWindow();
        stage.close();
    }
}
