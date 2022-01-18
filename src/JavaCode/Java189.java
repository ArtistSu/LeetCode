package JavaCode;

public class Java189 {
    /**
     * Title : Rotate Array
     * Stimulation
     * Time Complexity : O(1)
     * Space Complexity : O(K)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int numsLen = nums.length;
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = arr[numsLen - 1 - i];
        }

        for (int i = 0; i < numsLen - k; i++) {
            nums[numsLen - 1 - i] = nums[numsLen - 1 - k - i];
        }

        for (int i = k - 1; i >= 0; i--) {
            nums[i] = arr[i];
        }
    }
}
