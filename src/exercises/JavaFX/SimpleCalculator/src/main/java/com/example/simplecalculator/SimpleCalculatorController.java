package com.example.simplecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class SimpleCalculatorController {

    @FXML
    private TextField display;

    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleDigitButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        currentInput += clickedButton.getText();
        updateDisplay();
    }

    @FXML
    private void handleOperatorButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        operator = clickedButton.getText();
        firstOperand = Double.parseDouble(currentInput);
        currentInput = "";
    }

    @FXML
    private void handleClearButtonClick() {
        currentInput = "";
        firstOperand = 0;
        operator = "";
        updateDisplay();
    }

    @FXML
    private void handleEqualsButtonClick() {
        if (!operator.isEmpty() && !currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = performOperation(firstOperand, secondOperand, operator);
            currentInput = Double.toString(result);
            operator = "";
            updateDisplay();
        }
    }

    private void updateDisplay() {
        display.setText(currentInput);
    }

    private double performOperation(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    // 处理除以零的情况
                    return Double.NaN;
                }
            default:
                return 0;
        }
    }
}
