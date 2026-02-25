import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; this.next = null; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for palindrome:");
        String input = sc.nextLine();

        Node head = stringToLinkedList(input);

        if (isPalindrome(head)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        sc.close();
    }

    public static Node stringToLinkedList(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Node head = null, tail = null;
        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) { head = tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        }
        return head;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; fast = fast.next.next;
        }
        Node secondHalf = reverseList(slow.next);
        Node p1 = head, p2 = secondHalf;
        boolean result = true;
        while (p2 != null) {
            if (p1.data != p2.data) { result = false; break; }
            p1 = p1.next; p2 = p2.next;
        }
        return result;
    }

    public static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

