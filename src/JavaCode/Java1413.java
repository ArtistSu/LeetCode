package JavaCode;

public class Java1413 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@params nums}
     * Space Complexity: O(1)
     * @topic Minimum Value to Get Positive Step by Step Sum
     * @author ArtistS
     * @method Math
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        int minVal = Integer.MAX_VALUE, acculateSum = 0;
        for(int num : nums){
            acculateSum += num;
            minVal = Math.min(acculateSum, minVal);
        }
        return -minVal + 1;
    }
}
