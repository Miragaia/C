import java.util.Scanner;

public class calculadora1_aula01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextDouble()){
            System.out.println("Error: invalid value");
            System.exit(1);
        }
        double value1 = sc.nextDouble();
        String operation = sc.next();
        if(!sc.hasNextDouble()){
            System.out.println("Error: invalid value");
            System.exit(1);
        }
        double value2 = sc.nextDouble();
        double result = 0;
        sc.close();


        switch(operation){
                    case "+":
                        result = value1 + value2;
                        System.out.println("Soma: " + result);
                        break;
                    case "-":
                        result = value1 - value2;
                        System.out.println("Subtração: " + result);
                        break;
                    case "*":
                        result = value1 * value2;
                        System.out.println("Multiplicação: " + result);
                        break;
                    case "/":
                        result = value1 / value2;
                        System.out.println("Divisão: " + result);
                        break;
                    default:
                        System.out.println("Error: invalid operator");
                        System.exit(1);
                        break;
        }
    }
}
