import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // String expr = "(84 / 4 * 3 - 9) * 2 + 1 / 5"; // 108.2
        String expr = new String(" ");
        Scanner sc = new Scanner(System.in);
        Parser p;

        if (args.length == 0) {
            new GFrame("Calculator");
        } else {
            if (args[0].equals("-n")) {
                System.out.println("Type \"exit\" or Ctrl+C to exit.");
                while (true) {
                    System.out.print(">>> ");
                    expr = sc.nextLine();
                    if (!expr.equals("exit")) {
                        p = new Parser(expr);
                        System.out.println(p.eval());
                    } else {
                        sc.close();
                        break;
                    }
                }
            } else {
            }
        }
    }
}
