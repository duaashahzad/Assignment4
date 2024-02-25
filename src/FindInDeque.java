import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class FindInDeque<T> {

    private Stack<T> frontStack;
    private Stack<T> backStack;

    public FindInDeque() {
        frontStack = new Stack<>();
        backStack = new Stack<>();
    }

    public static int findElement(Deque<Integer> deque, int target) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        // Push all elements from deque onto both stacks
        for (int element : deque) {
            leftStack.push(element);
            rightStack.push(element);
        }

        int leftSize = leftStack.size();

        // Search for element while both stacks are not empty
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            int leftElement = leftStack.pop();
            int rightElement = rightStack.pop();

            if (leftElement == target) {
                return leftSize;
            } else if (rightElement == target) {
                return deque.size() - rightStack.size();
            }

            leftStack.push(rightElement);
            rightStack.push(leftElement);

            leftSize--;
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);

        int y = 30;
        int position = findElement(deque, y);

        if (position == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at position: " + position);
        }
    }

}