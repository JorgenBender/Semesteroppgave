module Semesteroppgave {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.Forsikringsregister to javafx.fxml;
    exports org.Forsikringsregister;
}