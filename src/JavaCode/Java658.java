package JavaCode;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Java658 {
    /**
     * Time Complexity: O(logn + k) {@param n} is the length of {@param arr}, k is {@param k}
     * Space Complexity: O(k)
     * @param arr
     * @param k
     * @param x
     * @return
     * @topic  Find K Closest Elements
     * @author ArtistS
     * @method Two pointers + Binary search
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}
