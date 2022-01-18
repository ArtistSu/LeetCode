package JavaCode;

public class Java26 {
    /**
     * @param nums
     * @return
     * @Title : Remove Duplicates from Sorted Array
     * Two Pointers
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public int removeDuplicates2(int[] nums) {
        int start = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }

    public int removeDuplicates(int[] nums) {
        int sortPosition = 0;
        int leftDigits = nums.length;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[sortPosition]) {
                leftDigits--;
                continue;
            } else {
                nums[++sortPosition] = nums[i];
            }
        }
        return leftDigits;
    }

}
