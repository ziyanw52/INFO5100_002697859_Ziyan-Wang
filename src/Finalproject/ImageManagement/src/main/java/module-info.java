module com.example.imagemanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires metadata.extractor;
    requires javaxt.core;

    opens com.example.imagemanagement to javafx.fxml;
    opens com.example.imagemanagement.controller to javafx.fxml;
    exports com.example.imagemanagement.controller to javafx.fxml;
    exports com.example.imagemanagement.app to javafx.graphics;
}