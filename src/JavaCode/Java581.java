package JavaCode;

import java.util.Arrays;

public class Java581 {
    /**
     * Time Complexity: O(n) n is the length of nums
     * Space Complexity: O(n)
     * @topic Shortest Unsorted Continuous Subarray
     * @author ArtistS
     * @param nums
     * @return
     * tips: Just for practising Quick Sort, you can use Arrays.sort(nums) directly.
     */
    public int findUnsortedSubarray(int[] nums) {
        if(isSorted(nums)){
            return 0;
        }
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        quickSort(nums, 0, nums.length-1);
        int left = 0;
        while (left <nums.length &&nums[left] == numsCopy[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (right > 0 && nums[right] == numsCopy[right]) {
            right--;
        }
        return right - left + 1;
    }
    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int middle = partition(arr, start, end);
        quickSort(arr, start, middle-1);
        quickSort(arr, middle+1, end);
    }
    public int partition(int[] arr, int start, int end){
        int i = start, j = end;
        while(i < j){
            while(i < j && arr[j] > arr[start]){
                j--;
            }
            while(i < j && arr[i] <= arr[start]){
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
