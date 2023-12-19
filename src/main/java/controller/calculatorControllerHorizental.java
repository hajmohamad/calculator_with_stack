package controller;

import com.example.calculator_stack.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class calculatorControllerHorizental {

    @FXML
    private AnchorPane anchorPane_digram;

    @FXML
    private Button brn_divis;
    public static Stage stage;

    @FXML
    private Button btn_0;
    @FXML
    private Button btn_printDiagram;

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
    private Button btn_bracet1;

    @FXML
    private Button btn_bracet2;

    @FXML
    private Button btn_digram;

    @FXML
    private Button btn_digram1;

    @FXML
    private Button btn_dot;

    @FXML
    private Button btn_e;

    @FXML
    private Button btn_equls;

    @FXML
    private Button btn_fact;

    @FXML
    private Button btn_min;

    @FXML
    private Button btn_multi;

    @FXML
    private Button btn_pi;

    @FXML
    private Button btn_plus;

    @FXML
    private Button btn_pow;

    @FXML
    private Button btn_rnd;

    @FXML
    private Label lbl_history;

    @FXML
    void act_calculatorAnchor(ActionEvent event) {
        anchorPane_digram.setVisible(false);
    }
    @FXML
    void act_diagramAnchor(ActionEvent event) {
        anchorPane_digram.setVisible(true);
    }
    @FXML
    void act_e(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"e");
    }
    @FXML
    void act_facr(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"!");
    }
    @FXML
    void act_pi(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"π");
    }
    @FXML
    void act_pow(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+"^");
    }
    @FXML
    void act_rand(ActionEvent event) {
        clearLbl_SUM();
        lbl_sum.setText(lbl_sum.getText()+Math.random());
    }
    @FXML
    private Label lbl_sum;
    @FXML
    private Label lbl_time;
    @FXML
    private TextField tf_formal;
    void clearLbl_SUM(){
        if(lbl_sum.getText().equals("0")){
            lbl_sum.setText("");
        }
    }
    @FXML
    AnchorPane ap_linChart;
    @FXML
    Label lbl_btnCalculator;
    @FXML
    Button getBtn_digram1;
    @FXML
    void act_printDiagram(ActionEvent event) throws Exception {
        final NumberAxis xAxis = new NumberAxis(1,12,1);
        final NumberAxis yAxis = new NumberAxis(1,50,1);
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<>(xAxis,yAxis);
        lineChart.setMaxWidth(330);
        lineChart.setMaxHeight(230);

        XYChart.Series series = new XYChart.Series();
        series.setName("diagram 1-12");

        for(int i=0; i<12;i++){
            String S=tf_formal.getText().replaceAll("x", String.valueOf(i));
            String result=StackApp.findAnswer(S);
            double z= Double.parseDouble(result);
            series.getData().add(new XYChart.Data(i,z));

        }

        lineChart.getData().add(series);
        ap_linChart.getChildren().add(lineChart);
        lbl_btnCalculator.toFront();
        btn_digram1.toFront();





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
        lbl_sum.setText("0");}
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
    void act_equls(ActionEvent event) {
        try {
            StringBuilder order= new StringBuilder(lbl_sum.getText());
            while (order.toString().contains("e")){

                order.replace(order.toString().indexOf("e"),order.toString().indexOf("e")+1,"2.191647");


            }
            while (order.toString().contains("π")){

                order.replace(order.toString().indexOf("π"),order.toString().indexOf("π")+1,"3.1415192");
            }

            lbl_sum.setText(StackApp.findAnswer(order.toString()));
            String history="" ;
            for(int i=0;i<StackApp.history.size();i++){
                history=history+StackApp.history.get(i)+"\n";
            }
            lbl_history.setFont(new Font(15));

            lbl_history.setText(history);


        }catch (Exception ex){
            if(ex.getMessage().equals("خطا: " +":("+"پرانتز گذاری نامعتبر ")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("پرنتاز نداریم");
                alert.setHeaderText(null);
                alert.setContentText("خطا: " +":("+"پرانتز گذاری نامعتبر ");
                alert.showAndWait();}

        }
    }

}
