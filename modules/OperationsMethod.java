package modules;

import java.util.Map;

public class OperationsMethod {

    public double sum(double num1, double num2){
        return num1 +  num2;
    }

    public double subtract(double num1, double num2){
        return num1 -  num2;
    }

    public double multiply(double num1, double num2){
        return num1 *  num2;
    }


    public double divide(double num1, double num2){
        return num1 /  num2;
    }

    public double potency(double num1, double num2){
        return Math.pow(num1, num2);
    }

    public double raiz(double num1, double num2){
        return Math.round(Math.pow(num1, 1 / num2));
    }

    public boolean isANumber(String text){

        try{
            double number = Double.parseDouble(text);
            return true;
        }catch (NumberFormatException numberFormatException){
            return false;
        }
    }
}
