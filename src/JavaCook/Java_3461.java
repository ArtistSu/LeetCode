package JavaCook;

/**
 * @author ArtistS
 * @tag String Array
 * @prb https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_3461{
    public boolean hasSameDigits(String s) {
        // Convert the string to an array of integers
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // Process the array until we have two digits left
        while (digits.length > 2) {
            int newLength = digits.length - 1;
            int[] newDigits = new int[newLength];

            for (int i = 0; i < newLength; i++) {
                newDigits[i] = (digits[i] + digits[i + 1]) % 10;
            }

            // Update the digits array to the newly calculated digits
            digits = newDigits;
        }

        // Check if the final two digits are the same
        return digits[0] == digits[1];
    }
}