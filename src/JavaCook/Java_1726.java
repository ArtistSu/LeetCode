package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Array HashTable Counting
 * @prb https://leetcode.com/problems/tuple-with-same-product/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class Java_1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tempRes = nums[i] * nums[j];
                count += 8 * map.getOrDefault(tempRes, 0);
                map.put(tempRes, map.getOrDefault(tempRes, 0) + 1);
            }
        }
        return count;
    }
}