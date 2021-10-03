package JavaCode;

public class Java977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    // two pointer / two array  Time Complexity: O(N) Space Complexity: O(N)
    public int[] sortedSquares2(int[] nums) {
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        int[] resultArr = new int[nums.length];

        for (int i = resultArr.length - 1; i >= 0; i--) {
            if (Math.abs(nums[leftPoint]) > Math.abs(nums[rightPoint])) {
                resultArr[i] = nums[leftPoint] * nums[leftPoint];
                leftPoint++;
            } else {
                resultArr[i] = nums[rightPoint] * nums[rightPoint];
                rightPoint--;
            }
        }
        return resultArr;
    }
}
