import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for palindrome:");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        sc.close();
    }
}

// Encapsulated Palindrome logic
class PalindromeChecker {

    public boolean checkPalindrome(String str) {
        // Normalize string: remove non-alphanumeric, lowercase
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
