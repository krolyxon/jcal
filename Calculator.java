public class Calculator {
    public static void main(String[] args) {
        String expr = "(36 * 3 + 9 * 7) * (84 / 12) * 5";
        Parser p = new Parser(expr);
        String postfix = p.toPostFix();
        System.out.println(p.evalExpr(postfix));
    }
}
