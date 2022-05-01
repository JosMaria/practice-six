module org.genesiscode.practicesix {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.genesiscode.practicesix to javafx.fxml;
    exports org.genesiscode.practicesix;
}