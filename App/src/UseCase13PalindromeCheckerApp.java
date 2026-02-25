import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to test performance:");
        String input = sc.nextLine();

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        long startStack = System.nanoTime();
        boolean resultStack = isPalindromeStack(normalized);
        long endStack = System.nanoTime();

        long startDeque = System.nanoTime();
        boolean resultDeque = isPalindromeDeque(normalized);
        long endDeque = System.nanoTime();

        long startTwoPointer = System.nanoTime();
        boolean resultTwoPointer = isPalindromeTwoPointer(normalized);
        long endTwoPointer = System.nanoTime();

        System.out.println("\nPerformance Results:");
        System.out.println("Stack Approach: " + (endStack - startStack) + " ns, Result: " + resultStack);
        System.out.println("Deque Approach: " + (endDeque - startDeque) + " ns, Result: " + resultDeque);
        System.out.println("Two-Pointer Approach: " + (endTwoPointer - startTwoPointer) + " ns, Result: " + resultTwoPointer);

        sc.close();
    }

    public static boolean isPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }

    public static boolean isPalindromeDeque(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    public static boolean isPalindromeTwoPointer(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) if (str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }
}
