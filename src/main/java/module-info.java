module com.example.calculator_stack {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.calculator_stack to javafx.fxml;
    exports com.example.calculator_stack;
    exports controller;
    opens controller to javafx.fxml;
}