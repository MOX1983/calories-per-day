module com.example.calorie_counting {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.calorie_counting to javafx.fxml;
    exports com.example.calorie_counting;
}