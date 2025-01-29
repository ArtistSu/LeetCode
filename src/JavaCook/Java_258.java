package JavaCook;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/add-digits/description/
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class Java_258 {
        public int addDigits(int num) {
            if (num == 0) {
                return 0;
            } else if (num % 9 == 0) {
                return 9;
            } else {
                return num % 9;
            }
        }
}