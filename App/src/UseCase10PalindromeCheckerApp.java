import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for palindrome:");
        String input = sc.nextLine();

        // Normalize: remove spaces & non-alphanumeric, convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(normalized)) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring case & spaces).");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome (ignoring case & spaces).");
        }

        sc.close();
    }

    public static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
