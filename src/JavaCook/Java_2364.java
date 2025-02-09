package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Array HashTable Math Counting
 * @prb https://leetcode.com/problems/count-number-of-bad-pairs/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2364 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> pairs = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            // You should use int, caz the range up to 10^5
            int goodPairs = pairs.getOrDefault(i - nums[i], 0);
            pairs.put(i - nums[i], goodPairs + 1);
            // [0,1,2,3,4,5] i is current index, also means there will be another i pair generated during this round
            // so we need to use total number of new pairs generated this round  - the number of good pairs
            res = res + i - goodPairs;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Java_2364().countBadPairs(new int[]{1, 2, 3, 4, 5}));
    }
}