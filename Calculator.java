import modules.OperationsMethod;

import javax.swing.*;
import java.util.ArrayList;

public class Calculator {

    private static final ArrayList<String> dataMode = new ArrayList<>();

    private static OperationsMethod operationsMethod;

    public static void main(String[] args){
        operationsMethod = new OperationsMethod();
        loadCalculator();
    }

    public static void loadCalculator(){

        String text = JOptionPane
                .showInputDialog(null, "Bienvenido a la calculadora\n\nEscribe uno de estos numeros\npara hacer una operación:\n\n1 - Suma\n2 - Resta\n3 - Multiplicación\n4 - División\n5 - Potencia\n6 - Raiz\n ", "Calculadora", JOptionPane.QUESTION_MESSAGE);

        if (text == null){
            JOptionPane.showMessageDialog(null, "Gracias por usar la calculadora!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            return;
        }

        if (!operationsMethod.isANumber(text)){
            JOptionPane.showMessageDialog(null, "El texto no es un numero.","Error", JOptionPane.ERROR_MESSAGE);
            loadCalculator();
            return;
        }

        double mode = Double.parseDouble(text);

        if (mode <= 0 || mode >= 7){
            JOptionPane.showMessageDialog(null, "El modo que pusiste no existe, hazlo de nuevo.","Error",  JOptionPane.ERROR_MESSAGE);
            loadCalculator();
            return;
        }

        dataMode.add(text);
        loadNumber1();
    }

    public static void loadNumber1(){

        String numberText1 = JOptionPane
                .showInputDialog(null, "Por favor, ponga el primer numero.", "Primer numero", JOptionPane.QUESTION_MESSAGE);

        if (numberText1 == null){
            loadCalculator();
            return;
        }

        if (!operationsMethod.isANumber(numberText1)){
            JOptionPane.showMessageDialog(null, "El texto no es un numero. Hazlo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
            loadNumber1();
            return;
        }

        dataMode.add(numberText1);
        loadNumber2();
    }

    public static void loadNumber2(){

        String numberText2 = JOptionPane
                .showInputDialog(null, "Por favor, ponga el segundo numero.", "Segundo numero", JOptionPane.QUESTION_MESSAGE);

        if (numberText2 == null){
            loadCalculator();
            return;
        }

        if (!operationsMethod.isANumber(numberText2)){
            JOptionPane.showMessageDialog(null, "El texto no es un numero. Hazlo de nuevo." ,"Error", JOptionPane.ERROR_MESSAGE);
            loadNumber2();
            return;
        }

        dataMode.add(numberText2);
        calculateNumber();
    }

    public static void calculateNumber(){

        int mode = Integer.parseInt(dataMode.get(0));

        double number1 = Double.parseDouble(dataMode.get(1));
        double number2 = Double.parseDouble(dataMode.get(2));

        String resultado;

        resultado = switch (mode) {
            case 1 -> String.valueOf(operationsMethod.sum(number1, number2));
            case 2 -> String.valueOf(operationsMethod.subtract(number1, number2));
            case 3 -> String.valueOf(operationsMethod.multiply(number1, number2));
            case 4 -> String.valueOf(operationsMethod.divide(number1, number2));
            case 5 -> String.valueOf(operationsMethod.potency(number1, number2));
            case 6 -> String.valueOf(operationsMethod.raiz(number1, number2));
            default -> "test";
        };

        JOptionPane.showMessageDialog(null, "El resultado de la operación es " + resultado + ".", "Resultado", JOptionPane.INFORMATION_MESSAGE);

        dataMode.clear();
        loadCalculator();
    }



}

























