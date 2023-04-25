package calcMain;
import calcModes.*;
import calcInterface.*;
import java.util.Scanner;
import java.math.BigInteger;

public class CalculatorMain {
    public static void main(String args[]){
        
        BaseOpInterface interfaceVar = new BaseCalculator(BigInteger.ONE, BigInteger.ONE);
        interfaceVar.addition();
        

        Scanner inputScan = new Scanner(System.in);
        String stringInput1, stringInput2, operator;
        BaseCalculator inputNumbers;

        System.out.print("Enter first integer: ");
        stringInput1 = inputScan.next();

        System.out.print("Choose math operation (+, -, *, /, ^, %, mod, log, lg, sin, cos, tan): ");
        operator = inputScan.next();

        if(operator.length() > 1 && !(operator.equals("mod"))){
            System.out.println();
            inputNumbers = new ScientificCalculator(
                new BigInteger(stringInput1)
            );
        }
        else{
            System.out.print("Enter second integer: ");
            stringInput2 = inputScan.next();
            
            if(operator.equals("mod") || operator.equals("%") || operator.equals("^")){
                inputNumbers = new SimpleCalculator(
                    new BigInteger(stringInput1), 
                    new BigInteger(stringInput2)
                );
            }
            else{
                inputNumbers = new BaseCalculator(
                    new BigInteger(stringInput1), 
                    new BigInteger(stringInput2)
                );
            }
        }
        inputScan.close();

        switch(operator){
            case "+":
                inputNumbers.addition();
                break;
            case "-":
                inputNumbers.subtraction();
                break;
            case "*":
                inputNumbers.multiplication();
                break;
            case "/":
                inputNumbers.division();
                break;
            case "^":
                ((SimpleCalculator)inputNumbers).power();
                break;
            case "%":
                ((SimpleCalculator)inputNumbers).percent();
                break;
            case "mod":
                ((SimpleCalculator)inputNumbers).mod();
                break;
            case "log":
                ((ScientificCalculator)inputNumbers).log();
                break;
            case "lg":
                ((ScientificCalculator)inputNumbers).lg();
                break;
            case "sin":
                ((ScientificCalculator)inputNumbers).sin();
                break;
            case "cos":
                ((ScientificCalculator)inputNumbers).cos();
                break;
            case "tan":
                ((ScientificCalculator)inputNumbers).tan();
                break;
            default:
               System.out.println("Invalid operator");
        }

        System.out.println(inputNumbers.toString());
        
    }   
}
