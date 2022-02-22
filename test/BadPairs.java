import javafx.scene.chart.BarChart;

import java.util.Arrays;

public class BadPairs {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,3,10,9,8,4};
        int[] arr2 = new int[]{1,3,6,7,2,4,5,8};
        new BadPairs().findBadPairs(arr);
        System.out.println(new BadPairs().findBadPairs2(arr2,3));
    }

    /**
     * Time complexity: O(n2)
     * Space complexity: O(1)
     * @param arr
     * @author: Allen Su
     */
    public void findBadPairs(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]+2){
                    System.out.println(arr[i] + "," + arr[j]);
                }
            }
        }
    }

    /**
     * Scenario: The first half and second half are fully sorted, but the
     * whole array is not fully sorted.
     * [1,3,6,7|2,4,5,8]
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     * @param mid
     */
    private int findBadPairs2(int[] nums,int mid) {
        int left = 0;
        int right = nums.length -1;
        // copy a new array
        int[] temp  = Arrays.copyOf(nums,nums.length);

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]+2) {
                // 注意：这里是 <= ，写成 < 就不对，请思考原因
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }


}
