package JavaCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Java442 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @topic Find All Duplicates in an Array
     * @author ArtistS
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }

    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(m) {@code m} m is the number of duplicated digits in {@param nums}
     * @topic Find All Duplicates in an Array
     * @author ArtistS
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> visit = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            if(visit.contains(num)){
                ans.add(num);
                continue;
            }
            visit.add(num);
        }
        return ans;
    }
}
