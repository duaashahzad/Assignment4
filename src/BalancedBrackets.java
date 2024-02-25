import java.util.Stack;

public class BalancedBrackets
{
    public static String isBalanced(String s)
    {
         Stack<Character> stack = new Stack<Character>();

         for(char bracket : s.toCharArray()) {
             if (bracket == '(' || bracket == '[' || bracket == '{') {
                 stack.push(bracket);
             } else {
                 if (stack.isEmpty()) {
                     return "NO";
                 }

                 char top = stack.pop();

                 if ((bracket == ')' && top != '(') || (bracket == ']' && top != '[') || (bracket == '}' && top != '{')) {
                     return "NO";
                 }
             }
         }

        if(!stack.isEmpty()) {
            return "NO";
        }

        return "YES";

    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));      // Output: YES
        System.out.println(isBalanced("{[(])}"));      // Output: NO
        System.out.println(isBalanced("{{[[(())]]}}")); // Output: YES
    }

}

