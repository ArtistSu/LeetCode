package JavaCode;

public class Java908 {
    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * @topic Smallest Range I
     * @author ArtistS
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int num : nums){
            if(num < smallest){
                smallest = num;
            }
            if(num > largest){
                largest = num;
            }
        }
        return largest - Math.abs(k) < smallest + Math.abs(k) ? 0 : largest - smallest - 2*Math.abs(k);
    }
}
