public class Calculator {
    public static void main(String[] args) {
        GFrame frame = new GFrame("Calculator");
        String expr = "(84 / 4 * 3 - 9) * 2 + 1 / 5"; // 108.2
        Parser p;
        if (args.length == 0) {
            p = new Parser(expr);
        } else {
            p = new Parser(args[0]);
        }
        System.out.println("postfix => \t " + p.getPostfix());
        System.out.println(p.eval());
    }
}
