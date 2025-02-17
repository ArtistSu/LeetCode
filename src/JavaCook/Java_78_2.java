package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array Backtracking
 * @prb https://leetcode.com/problems/subsets/solutions/
 * Time complexity: O（n*2^n）
 * Space complexity: O(n)
 */
public class Java_78_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                List<Integer> temp = new ArrayList(curr);
                temp.add(num);
                newSubsets.add(temp);
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}