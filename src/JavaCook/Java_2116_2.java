package JavaCook;

/**
 * @author ArtistS
 * @tag DynamicBalance
 * @prb https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2116_2 {
    class Solution {
        public boolean canBeValid(String parentheses, String status) {
            int length = parentheses.length();
            if (length % 2 != 0) return false;
            int minBalance = 0, maxBalance = 0;
            for (int i = 0; i < length; i++) {
                boolean isOpening = parentheses.charAt(i) == '(';
                boolean isUnlocked = status.charAt(i) == '0';
                minBalance += (!isOpening || isUnlocked) ? -1 : 1;
                maxBalance += (isOpening || isUnlocked) ? 1 : -1;
                // The number of ) & 1  > the number of ( or 0
                if (maxBalance < 0) return false;
                minBalance = Math.max(minBalance, 0);
            }
            return minBalance == 0;
        }
    }
}
/**
 * ) 0-> -1
 * ) 1 -> -1
 * ( 0 -> -1
 * ( 1 -> 1
 *
 * ( 0 -> 1
 * ( 1 -> 1
 * ) 0 -> 1
 * ) 1 -> -1
 * If fixed) > variable + fixed (, then there will never be a complete ()
 * So maxBalance must be < 0 to have a complete (), that is
 * fixed) < variable + fixed (
 * It means that there is still variable or fixed (, if maxBalance>0, then the string will start with ), so it must be false
 *
 * Then we let fixed ( < variable + fixed) This means that there must be variable and fixed) in each stage to let it close, if fixed ( > 0
 * It means that there is a fixed ( left at the end, and there is no character to close it, so it is judged that minBalance == 0
 */