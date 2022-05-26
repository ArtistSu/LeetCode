package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Java15 {
    /**
     * Time Complexity: O(n ^ 3) {@code n} is the length of (@param nums)
     * Space Complexity: O(n)
     * @topic 3Sum
     * @author ArtistS
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        ;
        int len = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = 0 - nums[first];
            int third = len - 1;
            for (int second = first + 1; second < len; second++) {
                if (second > (first + 1) && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

}
