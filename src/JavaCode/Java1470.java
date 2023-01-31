package JavaCode;

public class Java1470 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Shuffle the Array
     * @author AtristS
     * @method Traverse
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i = 0; i < n; i++){
            res[2*i] = nums[i];
            res[2*i+1] = nums[i+n];
        }
        return res;
    }
}
