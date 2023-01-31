package JavaCode;

import java.util.Arrays;

public class Java977 {
    /**
     * Time Complexity: O(nlogn) {@params n} is the length of {@params nums}
     * Space Complexity: O(logn)
     * @topic Squares of a sorted array
     * @author ArtistS
     * @method Find the split point + merge sort
     * @param nums
     * @return
     */
    public int[] sortedSquares4(int[] nums) {
        // Find the split point
        int split_point = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]<0){
                split_point = i;
            }else{
                break;
            }
        }

        // Merge sort
        int[] res = new int[nums.length];
        int index = 0, i = split_point, j = split_point + 1;
        while(i >= 0 || j < nums.length){
            if(i < 0){
                res[index] = nums[j] * nums[j];
                j++;
            }else if ( j == nums.length){
                res[index] = nums[i] * nums[i];
                i--;
            }else if(nums[i] * nums[i] < nums[j] * nums[j]){
                res[index] = nums[i] * nums[i];
                i--;
            }else{
                res[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return res;
    }
    /**
     * Time Complexity: O(nlogn) {@params n} is the length of {@params nums}
     * Space Complexity: O(logn)
     * @topic Squares of a sorted array
     * @author ArtistS
     * @method Square + Sort
     * @param nums
     * @return
     */
    public int[] sortedSquares3(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

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
