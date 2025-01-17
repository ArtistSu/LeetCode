package JavaCook;

/**
 * @author ArtistS
 * @tag Xor
 * @prb https://leetcode.com/problems/neighboring-bitwise-xor/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2683_2 {
    public boolean doesValidArrayExist(int[] derived) {
        int[] original = new int[derived.length + 1];
        original[0] = 0;

        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForZero = (original[0] == original[original.length - 1]);

        original[0] = 1;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForOne = (original[0] == original[original.length - 1]);

        return checkForZero || checkForOne;
    }
}