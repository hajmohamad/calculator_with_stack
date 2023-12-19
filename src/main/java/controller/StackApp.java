package controller;
import javafx.scene.control.Alert;
import model.LinkedListStack;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StackApp {
   static ArrayList<String> history ;
    public static void print(LinkedListStack<String> str){
        String a;
        String b;
        String c;

while (str.size()>=3){
    a=str.pop();
    c=str.pop();
    b=str.pop();
    str.push("("+a+b+c+")");
}
history.add(str.pop());

    }
    public static double postfixToEvaluation(Stack<String> reversStack) {
        Stack<Double> st = new Stack<Double>();
        double x = 0, y = 0;
        LinkedListStack<String>  stackNumber=new LinkedListStack<>();
        while (!reversStack.isEmpty()){
            stackNumber.push(reversStack.pop());
        }
        LinkedListStack<String> copy;
        double result;

        while (!stackNumber.isEmpty()){
            String c=stackNumber.pop();
            if  (Objects.equals(c, "+") || Objects.equals(c, "-") || Objects.equals(c, "*") || Objects.equals(c, "/") || Objects.equals(c, "^") || Objects.equals(c, "!")) {
                y = st.pop();
                x = st.pop();
                switch (c) {
                    case "+":
                        result=x + y;
                        st.push(result);
                       copy= stackNumber.copy(String.valueOf(result));
                       print(copy);
                        break;
                    case "-":
                        result=x - y;
                        st.push(result);
                        copy= stackNumber.copy(String.valueOf(result));
                        print(copy);

                        break;
                    case "*":
                        result=x * y;
                        st.push(result);
                        copy= stackNumber.copy(String.valueOf(result));
                        print(copy);

                        break;
                    case "/":
                        result=x/ y;
                        st.push(result);
                        copy= stackNumber.copy(String.valueOf(result));
                        print(copy);

                        break;
                    case "^":
                        result=Math.pow(x, y);
                        st.push(result);
                        copy= stackNumber.copy(String.valueOf(result));
                        print(copy);

                        break;

                }
            }else {
                st.push(Double.valueOf(c));

            }
        }
        return st.pop();
    }
    public static Stack<String> infixToPostfix(String order) {
        String pattern = "([-+*^/()!])|([0-9]+([.][0-9]+)?)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(order);
        Stack<String> st = new Stack<String>();
        Stack<String> postfixStack=new Stack<>();
        ArrayList<String> StringList=new ArrayList<>();
        while (matcher.find()) {
            StringList.add(matcher.group());
        }

        for (String c : StringList) {

            if (!c .equals("+")  && !c .equals("-")  &&!c .equals("*")  &&!c .equals("/") && !c .equals("(")  && !c .equals(")")  && !c .equals("^") && !c .equals('^') ) {
                postfixStack.push(c);
            } else if (c.equals("(")) {
                st.push(c);
            } else if (c.equals(")")) {
                while (!st.isEmpty()) {
                    String t = st.pop();
                    if (!Objects.equals(t, "(")) {
                        postfixStack.push(t);
                    } else {
                        break;
                    }




                }
            } else if  (Objects.equals(c, "+") || Objects.equals(c, "-") || Objects.equals(c, "*") || Objects.equals(c, "/") || Objects.equals(c, "^") || Objects.equals(c, "!")) {
                if (st.isEmpty()) {
                    st.push(c);
                } else {
                    while (!st.isEmpty()) {
                        String t = st.pop();
                        if (Objects.equals(t, "(")) {
                            st.push(t);
                            break;
                        } else if (Objects.equals(t, "+") || Objects.equals(t, "-") || Objects.equals(t, "*") || Objects.equals(t, "/") || Objects.equals(t, "^") || Objects.equals(t, "!")) {
                            if (getPriority(t) < getPriority(c)) {
                                st.push(t);
                                break;
                            } else {
                                postfixStack.push(t);
                            }
                        }
                    }
                    st.push(c);
                }
            }
        }

        while (!st.isEmpty()) {
            String temp=st.pop();
            postfixStack.push(temp);
        }
        return postfixStack;
    }
    public static int getPriority(String c) {
        if (Objects.equals(c, "+") || Objects.equals(c, "-")) {
            return 1;
        } else if (Objects.equals(c, "*") || Objects.equals(c, "/")) {
            return 2;
        } else if (Objects.equals(c, "^")) {
            return 3;
        } else {
            return 0;
        }
    }
    public static Boolean  checkBracket(String str){
        int BracketCounter=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                BracketCounter++;

            }else if(str.charAt(i)==')'&&BracketCounter>0){
                BracketCounter--;
            }else if (str.charAt(i)==')'&&BracketCounter<=0){
                return false;
            }

        }
        return true;
    }
    public static String calculationFactorial(String order){
        String result="";
        String current;
        String previous;
        String pattern = "([-+*^/()!])|([0-9]+([.][0-9]+)?)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(order);
        matcher.find();
        previous=matcher.group();
        while (matcher.find()) {
            current=matcher.group();
            if(current.equals("!")){
                double number= Double.parseDouble(previous);
                number=factorial(number);
                result=result+number;
                previous=matcher.group();
            }else{
                result=result+previous;
                previous=current;
            }}
        return result;
    }
    public static double factorial(double n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static String findAnswer(String order) throws Exception {

        double result = 0;
        if((!checkBracket(order))){
            throw new Exception("خطا: " +":("+"پرانتز گذاری نامعتبر ");
        }else {
//        calculationFactorial
            if(order.contains("!")){
                order= calculationFactorial(order);
            }
            try {
                history=new ArrayList<>();
                result = postfixToEvaluation( infixToPostfix(order));

            }catch (Exception ep){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText(null);
                alert.setContentText("ورودی اعداد اشتباه هستش اعدادی ک نیاز ب محاسابت داره رو دوباره ب شکل صحیح وارد کنید");
                alert.showAndWait();

            }

        }
        return String.valueOf(result);}


    }



