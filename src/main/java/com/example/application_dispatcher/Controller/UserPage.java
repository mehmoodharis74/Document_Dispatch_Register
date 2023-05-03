package com.example.application_dispatcher.Controller;


import com.example.application_dispatcher.Classes.Controller;
import com.example.application_dispatcher.Constant.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UserPage extends Controller {
    @FXML
    Button logoutButton;
    @FXML
    Button searchAppBtn_onAction;
    @FXML
    Button applyForComplainBtn;
    @FXML
    Button trackActivityBtn;
    @FXML
    Button viewDegreeBtn;
    @FXML
    Button applyForTranscriptBtn;
    @FXML
Label navName;
@FXML
    VBox findDegreeVBox,ApplyForDegreeVBox;

    public void initialize(){
        if(!Constants.CURRENT_USER_NAME.isEmpty())
            navName.setText(Constants.CURRENT_USER_NAME);
        //if request is completed and hod_signature is Approved from database then findDegreeVBox will be visible
//        if(getDegreeRequestStatus(String.valueOf(Constants.CURRENT_USER_ID))){
//            ApplyForDegreeVBox.setDisable(true);
//            findDegreeVBox.setDisable(true);
//           // ActivityTrackingVBox.setDisable(false);
//
//        }
//        else {
//            ApplyForDegreeVBox.setDisable(false);
//            findDegreeVBox.setDisable(true);
//           // ActivityTrackingVBox.setDisable(true);
//        }
//        findDegreeVBox.setDisable(!isDegreeSaved(String.valueOf(Constants.CURRENT_USER_ID)));
    }

    public void searchAppBtn_onAction(ActionEvent actionEvent) {
        
    }

    public void trackAppBtn_onAction(ActionEvent actionEvent) {
    }

    public void pendingAppBtn_onAction(ActionEvent actionEvent) {
    }

    public void submitAppBtn_onAction(ActionEvent actionEvent) {
    }
}
