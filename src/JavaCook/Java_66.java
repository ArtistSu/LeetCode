package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/plus-one/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_66 {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0]=1;
        return res;
    }
}