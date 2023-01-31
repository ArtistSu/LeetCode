package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java45 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @topic Jump Game II
     * @author ArtistS
     * @method Greedy
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxPosition = Math.max(maxPosition, nums[i]+i);
            if(i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Jump Game II
     * @author ArtistS
     * @method Traverse
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int minStep = nums.length-1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums.length - 1, minStep);
        map.put(0,0);
        int right = 0;

        for(int i = 0; i < nums.length; i++){
            right = i + nums[i];
            for(int j = i+1; j <= right;j++){
                map.put(j,Math.min(map.get(i)+1, map.getOrDefault(j,j)));
            }
        }
        return map.get(nums.length-1);
    }
}
