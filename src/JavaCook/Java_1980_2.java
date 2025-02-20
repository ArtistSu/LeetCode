package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/find-unique-binary-string/description/
 * Time complexity:O(n)
 * Space complexity: O(1)
 */
public class Java_1980_2 {

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            ans.append(nums[i].charAt(i) == '0' ? '1' :'0');
        }
        return ans.toString();
    }
}