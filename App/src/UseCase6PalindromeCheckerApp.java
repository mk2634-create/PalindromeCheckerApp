import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       Palindrome Checker App");
        System.out.println("=================================");

        System.out.println("UC6: Queue + Stack Based Palindrome Check");

        String input = "civic";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into stack and queue
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            queue.add(input.charAt(i));     // FIFO
        }

        boolean isPalindrome = true;

        // Compare pop (stack) with dequeue (queue)
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println("Program Ended.");
    }
}
