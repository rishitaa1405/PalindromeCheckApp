import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Two Pointer Approach
    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack Based Approach
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Method 3: String Reverse Approach
    public static boolean reversePalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize input
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Two Pointer Performance
        long start1 = System.nanoTime();
        boolean result1 = twoPointerPalindrome(normalized);
        long end1 = System.nanoTime();

        // Stack Performance
        long start2 = System.nanoTime();
        boolean result2 = stackPalindrome(normalized);
        long end2 = System.nanoTime();

        // Reverse String Performance
        long start3 = System.nanoTime();
        boolean result3 = reversePalindrome(normalized);
        long end3 = System.nanoTime();

        // Display results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("\nStack Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("\nReverse String Result: " + result3);
        System.out.println("Execution Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}