package JavaCode;

public class Java268 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Missing Number
     * @author ArtistS
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        boolean[] visit = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            visit[nums[i]] = true;
        }
        for (int i = 0; i < len + 1; i++) {
            if (visit[i] == false) {
                return i;
            }
        }
        return -1;
    }

}
