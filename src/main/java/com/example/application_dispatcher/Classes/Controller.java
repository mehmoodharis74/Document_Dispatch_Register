package com.example.application_dispatcher.Classes;

import com.example.application_dispatcher.Classes.database;
import com.example.application_dispatcher.Constant.Constants;
import com.example.application_dispatcher.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class Controller {
    private static database db = null;
    public static String[] path =new String[10];
    public static Integer pathIndex=0;

    @FXML
    Button login_page_loginBtn,logoutButton;


    static {
        try {
            db = new database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void pageLoader(String page) {
        if (pathIndex!=0 && path[pathIndex-1].equals(page)) {
            pathIndex--;
        }
        path[pathIndex]=page;
        Stage stage;

        if(logoutButton !=null )
            stage = (Stage) logoutButton.getScene().getWindow();
        else {
            stage = (Stage) login_page_loginBtn.getScene().getWindow();
        }
//        if(!stage.isMaximized()) {
//            stage.setMaximized(true);
//        }
       /* GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = graphicsDevice.getDisplayMode().getWidth();
        int height = graphicsDevice.getDisplayMode().getHeight();*/

        try {
           /* stage.setHeight(height);
            stage.setWidth(width);*/
            stage.setMinWidth(900);
            stage.setMinHeight(640);
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(path[pathIndex])))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pathIndex++;
    }

    public void backArrow_onClick() {
        pathIndex--;
        pageLoader(path[pathIndex-1]);
    }

    @FXML
    protected void logOut_onAction() {
        //navigate to login page
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setMaximized(true);
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("login_page.fxml")))));
            Constants.CURRENT_USER_NAME = "";
            Constants.CURRENT_USER_ID = 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pathIndex=0;
        Constants.clearStrings();
    }
    public boolean verifyUserLogin(String email, String password) {


        String query = null;
        boolean found = false;
        query = "select * FROM users WHERE email = " + email + " AND password = '" + password + "'";


        ResultSet reader = db.executeQuery(query);
        while (true) {
            try {
                if (!reader.next()) break;
                else if (reader.getString("email").equals(email) &&
                        reader.getString("password").equals(password)) {
                    found = true;
                    Constants.CURRENT_USER_ID = reader.getInt("id");
                    Constants.CURRENT_USER_EMAIL = reader.getString("email");
                    Constants.CURRENT_USER_NAME = reader.getString("name");
//                    if (Objects.equals(user_type, "Student")) {
//                        Constants.CURRENT_USER_NAME = reader.getString("sName");
//                        Constants.CURRENT_USER_TYPE = "Student";
//                    }
//                    else if (Objects.equals(user_type, "FypCommittee")) {
//                        Constants.CURRENT_USER_NAME = reader.getString("fyp_name");
//                        Constants.CURRENT_USER_TYPE = "Fyp";
//                    }
//                    else if (Objects.equals(user_type, "Admin")) {
//                        Constants.CURRENT_USER_NAME = reader.getString("a_Name");
//                        Constants.CURRENT_USER_TYPE = "Admin";
//                    }
//                    else if (Objects.equals(user_type, "Director")) {
//                        Constants.CURRENT_USER_NAME = reader.getString("d_Name");
//                        Constants.CURRENT_USER_TYPE = "Director";
//                    }
//                    else if (Objects.equals(user_type, "FinanceCommittee")) {
//                        Constants.CURRENT_USER_NAME = reader.getString("f_Name");
//                        Constants.CURRENT_USER_TYPE = "Finance";
//                    }
                    // if(navName != null)

                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return found;
    }
}
