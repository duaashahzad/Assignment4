import java.util.Stack;
public class InfixToPostfix {

    public static int getPrecedence(char operator)
    {
       switch (operator) {
        case '^':
            return 3;
        case '*':
        case '/':
            return 2;
        case '+':
        case '-':
            return 1;
        default:
            return 0; // for operands
        }
    }

    public static String infixToPostfix(String infix) {

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        // Sample Input
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";

        // Output
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println(postfixExpression);
    }
}
