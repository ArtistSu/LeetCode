package JavaCode;

public class Java27 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param nums}
     * Space Complexity:O(1)
     * @topic Remove Element
     * @author ArtistS
     * @method Two Pointers
     * @param nums
     * @param val
     * @return
     */
    public int removeElement4(int[] nums, int val) {
        int pointA = 0, pointB = nums.length;
        while(pointA < pointB){
            if(nums[pointA] == val){
                nums[pointA] = nums[pointB-1];
                pointB--;
            }else{
                pointA++;
            }
        }
        return pointA;
    }

    /**
     * Title: Remove Element
     * Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int removeIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[removeIdx] = nums[i];
                removeIdx++;
            }
        }
        return removeIdx;
    }



        public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // Use two pointer technique
    // Space Complexity : O(1)  Time Complexity: O(N)
    public int removeElement(int[] nums, int val) {
        int writePoint = 0;
        int resultNumber = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] != val){
                nums[writePoint] = nums[i];
                writePoint++;
            }
            if(nums[i] == val){
                resultNumber--;
            }
        }
        return resultNumber;
    }

}

