package Q50;

import java.util.stream.IntStream;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));   // true

        System.out.println(isPalindrome("level"));   // true

        System.out.println(isPalindrome("hello"));   // false

        System.out.println(isPalindrome("racecar")); // true

        System.out.println(isPalindrome("radar"));   // true
    }

    private static boolean isPalindrome(String str) {
        return IntStream.range(0, str.length())
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }
}

