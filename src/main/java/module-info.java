module com.example.application_dispatcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.application_dispatcher to javafx.fxml;
    exports com.example.application_dispatcher;
    exports com.example.application_dispatcher.Classes;
    opens com.example.application_dispatcher.Classes to javafx.fxml;
    exports com.example.application_dispatcher.Controller;
    opens com.example.application_dispatcher.Controller to javafx.fxml;
}