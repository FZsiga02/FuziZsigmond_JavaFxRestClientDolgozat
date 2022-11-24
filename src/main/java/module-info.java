module hu.petrik.fuzizsigmond_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.petrik.fuzizsigmond_javafxrestclientdolgozat to javafx.fxml;
    exports hu.petrik.fuzizsigmond_javafxrestclientdolgozat;
}