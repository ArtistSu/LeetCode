package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Xor Math
 * @prb https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/
 * Time complexity: O(m+n)
 * Space complexity: O(m+n)
 */
public class Java_2425{
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor_1 = 0;
        int xor_2 = 0;

        if(nums2.length % 2 != 0){
            for(int num : nums1){
                xor_1 ^= num;
            }
        }

        if(nums1.length % 2 != 0){
            for(int num : nums2){
                xor_2 ^= num;
            }
        }

        return xor_1 ^ xor_2;
    }
}