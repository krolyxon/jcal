public class Calculator {
    public static void main(String[] args) {
        String expr = "(84 / 4 * 3 - 9) * 2 + 1 / 5"; // 108.2
        Parser p;
        if (args.length == 0) {
            p = new Parser(expr);
        } else {
            p = new Parser(args[0]);
        }
        String postfix = p.toPostFix();
        // System.out.println("pfix => \t " + postfix);
        System.out.println(p.evalExpr(postfix));
    }
}
