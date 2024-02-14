/* Todo
* - Fix Substraction errors
* - Add support for trigonometric functions
* - Remove all edge cases
*/

import java.util.Stack;
import java.util.StringJoiner;

public class Parser {
    private String expr;
    private Stack<Character> operatorStack;

    public Parser(String infixExpr) {
        expr = infixExpr.trim().replaceAll("\\s", ""); // remove whitespaces
    }

    public static boolean isOperand(char c) {
        switch (c) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    public static boolean isOperand(String c) {
        return isOperand(c.charAt(0));
    }

    public int getPresedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '/':
                return 2;
            case '*':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    public boolean hasLeftAssociativity(char c) {
        if (c == '^') {
            return false;
        } else {
            return true;
        }
    }

    public String toPostFix() {
        operatorStack = new Stack<>();
        StringJoiner output = new StringJoiner(" ");
        StringBuilder operand = new StringBuilder();
        char[] infix = expr.replaceAll(" ", "").toCharArray();

        // Main Expression Iteration
        for (int i = 0; i < infix.length; i++) {
            char c = infix[i];
            if (isOperand(c)) {
                operand.append(infix[i]);
                if (i < infix.length - 1) {
                    continue;
                }
            }

            if (operand.length() > 0) {
                output.add(operand.toString());
                operand = new StringBuilder();
            }

            if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    output.add(operatorStack.pop().toString());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && getPresedence(c) <= getPresedence((char) operatorStack.peek())
                        && hasLeftAssociativity(c)) {
                    output.add(operatorStack.pop().toString());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                return "This expression is invalid";
            }
            output.add(operatorStack.pop().toString());
        }

        // last digit gets duplicate entry for some reason, so have to remove it.
        String op = output.toString();
        return op.substring(0, op.length() -2);
    }

    private Double evaluate(String operator, Double op1, Double op2) {
        switch (operator.charAt(0)) {
            case '+':
                return op2 + op1;
            case '-':
                return op2 - op1;
            case '*':
                return op2 * op1;
            case '/':
                return op1 / op2;
            case '^':
                return (Math.pow(op2, op1));
            default:
                return 0.0;
        }
    }

    public double evalExpr(String postfix) {
        Stack<Double> stack = new Stack<Double>();
        for (String c : postfix.split(" ")) {
            if (isOperand(c)) {
                stack.push(Double.parseDouble(c));
            } else {
                Double op1 = (Double) (stack.pop());
                Double op2 = (Double) (stack.pop());
                stack.push(evaluate(c, op2, op1));
            }
        }
        return stack.pop();
    }
}
