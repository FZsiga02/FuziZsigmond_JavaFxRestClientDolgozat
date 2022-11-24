module hu.petrik.fuzizsigmond_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires jdk.internal.le;


    opens hu.petrik.fuzizsigmond_javafxrestclientdolgozat to javafx.fxml, com.google.gson;
    exports hu.petrik.fuzizsigmond_javafxrestclientdolgozat;
}