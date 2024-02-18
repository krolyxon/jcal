/* Todo
* - Add support for trigonometric functions
* - Remove all edge cases
*/

import java.util.Stack;
import java.util.StringJoiner;

public class Parser {
    private String expr;
    private String postfix;
    private Stack<Character> operatorStack;

    public Parser(String infixExpr) {
        expr = infixExpr.trim().replaceAll("\\s", ""); // remove whitespaces
        postfix = toPostFix();
    }

    private boolean isOperand(char c) {
        switch (c) {
            case '.':
            case '0':
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

    private boolean isOperand(String c) {
        return isOperand(c.charAt(0));
    }

    private int getPresedence(char c) {
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

    private boolean hasLeftAssociativity(char c) {
        if (c == '^') {
            return false;
        } else {
            return true;
        }
    }

    private String toPostFix() {
        operatorStack = new Stack<>();
        StringJoiner output = new StringJoiner(" ");
        StringBuilder operand = new StringBuilder();
        char[] infix = expr.replaceAll(" ", "").toCharArray();

        // Main Expression Iteration
        for (int i = 0; i < infix.length; i++) {
            char c = infix[i];

            // Keep appending digits to the operand StringBuilder and skip iterations till
            // we find a operator.
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
                // Manage precedence order of operatorStack operators
                while (!operatorStack.isEmpty() && getPresedence(c) <= getPresedence((char) operatorStack.peek())
                        && hasLeftAssociativity(c)) {
                    output.add(operatorStack.pop().toString());
                }

                // For whatever reason, the last digit gets added to the operatorStack, leading
                // to a duplicate of last digit in the expression
                // To fix this, we again make sure that the current char is not a operand.
                if (!isOperand(c)) {
                    operatorStack.push(c);
                }
            }
        }

        // pop all the operators left in the operatorStack after the loop is done.
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                return "This expression is invalid";
            }
            output.add(operatorStack.pop().toString());
        }

        return output.toString();
    }

    private Double evaluate(String operator, Double op1, Double op2) {
        switch (operator.charAt(0)) {
            case '+':
                return op2 + op1;
            case '-':
                return op1 - op2;
            case '*':
                return op2 * op1;
            case '/':
                return op1 / op2;
            case '^':
                return (Math.pow(op1, op2));
            default:
                return 0.0;
        }
    }

    public double eval() {
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

    public String getPostfix() {
            return postfix;
    }
}
