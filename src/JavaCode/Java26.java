package JavaCode;

public class Java26 {
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
