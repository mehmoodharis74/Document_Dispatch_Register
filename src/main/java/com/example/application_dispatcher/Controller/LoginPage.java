package com.example.application_dispatcher.Controller;

import com.example.application_dispatcher.Classes.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPage extends Controller {
    @FXML Button login_page_loginBtn;
    @FXML Label errorLabel;
    @FXML TextField login_email_input_field, login_password_input_field;



    public void loginBtn_onAction(){
        if(validDataInput()) {
            if(verifyUserLogin(login_email_input_field.getText(), login_password_input_field.getText())){
                pageLoader("user_page.fxml");
            }
            else{
                errorLabel.setText("Invalid Email or Password");
            }
        }


    }
    public boolean validDataInput() {
       if (login_email_input_field.getText().isEmpty()) {
                errorLabel.setText("Please enter Email");
                return false;
            }
       else if(login_password_input_field.getText().isEmpty()) {
           errorLabel.setText("Please enter Password");
           return false;
       }
        return true;
    }
}
