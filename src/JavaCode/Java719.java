package JavaCode;

import java.util.Arrays;

public class Java719 {

    /**
     * Time Complexity: O(nlogn * log M) {@code n} is the length of {@param nums}, {@code M} is the sub of Max(nums) - Min(nums)
     * Space Complexity: O(logn)
     * @method QuickSort + Binary Search
     * @topic Find K-th Smallest Pair Distance
     * @author ArtistS
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];
        while(left < right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                int j = binarySearch(nums, i, nums[i]-mid);
                cnt += i-j;
            }
            if(cnt >= k){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return left;
    }

    public int binarySearch(int[]nums, int end, int target){
        int left = 0;
        int right = nums.length - 1;
        int midIndex = 0;
        while(left < right){
            midIndex = left+(right-left)/2;
            if(nums[midIndex] < target){
                left = midIndex + 1;
            }else{
                right = midIndex;
            }
        }
        return left;
    }

    public void quickSort(int[] nums, int left, int right){
        if(left < right){
            int index = partition(nums, left, right);
            quickSort(nums, left, index-1);
            quickSort(nums, index+1, right);
        }
    }

    public int partition(int[] nums, int left, int right){
        int pivot = left;
        int pivotVal = nums[left];
        int index = left+1;
        if(left < right){
            for(int i = index; i <= right; i++){
                if(nums[i] < pivotVal){
                    swap(nums, index, i);
                    index++;
                }
            }
            swap(nums, pivot, index-1);
        }
        return index-1;
    }

    public void swap(int[] nums, int indexA, int indexB){
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

}
