package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array TwoPointers Simulation
 * @prb https://leetcode.com/problems/partition-array-according-to-given-pivot/description
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        List<Integer> equal = new LinkedList<>();

        // Split the nums
        for (int num : nums) {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                equal.add(num);
            }
        }

        left.addAll(equal);
        left.addAll(right);

        int[] res = new int[nums.length];
        int index = 0;
        for (int num : left) {
            res[index++] = num;
        }

        return res;
    }
}