package com.example.imagemanagement.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * basic javafx controller
 */
public abstract class AbstractController implements Initializable {
    /**
     * alert error msg
     * @param message
     */
    protected void alertError(String message) {
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.show();
    }

    /**
     * alert info msg
     * @param message
     */
    protected void alertInfo(String message) {
        Alert alert = new Alert(AlertType.INFORMATION, message);
        alert.show();
    }
}
