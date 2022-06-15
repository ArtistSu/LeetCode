package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java532 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @method Map
     * @topic K-diff Pairs in an Array
     * @author ArtistS
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        int res = 0;
        quickSort(nums, 0, nums.length - 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int val = map.get(num);
                map.put(num, val + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key - k)) {
                if (k == 0 && (map.get(key) <= 1)) {
                    continue;
                }
                res += 1;
            }
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = left;
        int pickVal = nums[left];
        int index = left + 1;
        if (left < right) {
            for (int i = index; i < nums.length; i++) {
                if (nums[i] < pickVal) {
                    swap(nums, i, index);
                    index++;
                }
            }
            swap(nums, pivot, index - 1);
        }
        return index - 1;
    }

    public void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}
