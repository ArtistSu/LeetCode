package JavaCode;

import java.util.HashMap;
import java.util.Map;


public class Java974 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(min(n, k))
     * @method prefix sum
     * @topic Subarray Sums Divisible by K
     * @author ArtistS
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int curr = (sum % k + k) % k;
            int times = record.getOrDefault(curr, 0);
            ans += times;
            record.put(curr, times+1);
        }
        return ans;
    }
}
