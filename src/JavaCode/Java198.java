package JavaCode;

public class Java198 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@params}
     * Space Complexity: O(1)
     * @topic House Robber
     * @author ArtistS
     * @method DP
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    /**
     * Time Complexity: O(n) {@param n} is the length of {@params}
     * Space Complexity: O(n)
     * @param nums
     * @return
     * @topic House Robber
     * @author ArtistS
     * @method DP
     */
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);

        int res = money[1];
        for (int i = 2; i < nums.length; i++) {
            money[i] = money[i - 2] + nums[i];
            money[i] = Math.max(money[i - 1], money[i]);
            res = Math.max(res, money[i]);
        }
        return res;
    }
}
