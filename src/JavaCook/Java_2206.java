package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Array HashTable BitManipulation Counting
 * @prb https://leetcode.com/problems/divide-array-into-equal-pairs/description
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2206 {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 == 1) return false;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.isEmpty();
    }
}