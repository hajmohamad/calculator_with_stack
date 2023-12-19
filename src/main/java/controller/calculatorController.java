package controller;

import com.example.calculator_stack.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

public class calculatorController implements Initializable {
    public static Stage stage;

    @FXML
    private Button brn_divis;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_ac;

    @FXML
    private Button btn_dot;

    @FXML
    private Button btn_equls;

    @FXML
    private Button btn_min;

    @FXML
    private Button btn_multi;


    @FXML
    private Button btn_plus;

    @FXML
    private Label lbl_sum;
    @FXML
    private Label lbl_sum1;

    @FXML
    private Label lbl_time;

    void clearLbl_SUM(){
        if(lbl_sum.getText().equals("0")){
            lbl_sum.setText("");
        }else{
            if(lbl_sum.getText().length()==8){
                String str=lbl_sum1.getText()+lbl_sum.getText();
                lbl_sum.setText(str.substring(str.length()-7,str.length()));
                lbl_sum1.setText(str.substring(0,str.length()-7));


            }
        }

    }

    @FXML
    void act_0(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+0);

    }

    @FXML
    void act_1(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+1);

    }

    @FXML
    void act_2(ActionEvent event) {
        clearLbl_SUM();

        lbl_sum.setText(lbl_sum.getText()+2);

    }

    @FXML
    void act_3(ActionEvent event) {
        clearLbl_SUM();

        lbl_sum.setText(lbl_sum.getText()+3);


    }

    @FXML
    void act_4(ActionEvent event) {
        clearLbl_SUM();

        lbl_sum.setText(lbl_sum.getText()+4);


    }

    @FXML
    void act_5(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+5);


    }

    @FXML
    void act_6(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+6);


    }

    @FXML
    void act_7(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+7);


    }

    @FXML
    void act_8(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+8);


    }

    @FXML
    void act_9(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+9);
    }

    @FXML
    void act_ac(ActionEvent event) {
        lbl_sum.setText("0");
        lbl_sum1.setText("");
    }

    @FXML
    void act_divis(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"/");

    }

    @FXML
    void act_dot(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+".");

    }

    @FXML
    void act_min(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"-");

    }

    @FXML
    void act_multi(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"*");

    }


    @FXML
    void act_bracet1(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"(");

    }

    @FXML
    void act_bracet2(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+")");

    }


    @FXML
    void act_plus(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"+");

    }

    @FXML
    void btn_equls(ActionEvent event) {
        try {
       lbl_sum.setText(StackApp.findAnswer(lbl_sum1.getText()+lbl_sum.getText()));

        }catch (Exception ex){
            if(ex.getMessage().equals("خطا: " +":("+"پرانتز گذاری نامعتبر ")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("پرنتاز نداریم");
            alert.setHeaderText(null);
            alert.setContentText("خطا: " +":("+"پرانتز گذاری نامعتبر ");
            alert.showAndWait();}

       }
    }
    @FXML
    void act_horizental(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(calculator.class.getResource("fXMLcalculatorHorizental.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 650, 319);
        stage.setScene(scene1);
        scene1.setFill(Color.TRANSPARENT);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        String time = formatter.format(new Date());
        lbl_time.setText(time.toString().substring(0,5));

    }
}
