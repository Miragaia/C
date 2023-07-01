class calculadora {
    public static void main(String[] args) {
        if (args.length==0){                                                    //verificação se existem argumentos
            System.out.println("Error: no arguments");
            System.exit(0);
        }

        if (args.length>3){                                                     //verificação se existem mais de 3 argumentos
            System.out.println("Error: too many arguments");
            System.exit(0);
        }

        if (args.length<3){                                                     //verificação se existem menos de 3 argumentos
            System.out.println("Error: too few arguments");
            System.exit(0);
        }

        if (args[1].equals("+") || args[1].equals("-") || args[1].equals("*") || args[1].equals("/")){ //verificação se o operador é válido
            System.out.println("Error: invalid operator");
            System.exit(0);
        }

        int value1 = Integer.parseInt(args[0]);                                 //conversão de string para inteiro
        int value2 = Integer.parseInt(args[2]);
        String operation = args[1];
        int result=0;

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
                        System.exit(0);
                        break;
        }
    }
}