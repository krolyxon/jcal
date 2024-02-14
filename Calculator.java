public class Calculator {
    public static void main(String[] args) {
        String expr = "(84 / 4 * 3 - 9) * 2 + 1 / 5"; // 108.2
        Parser p = new Parser(expr);
        String postfix = p.toPostFix();
        System.out.println(p.evalExpr(postfix));
    }
}
