package JavaCook;

/**
 * @author ArtistS
 * Time complexity: O(n)
 * Space complexity: O(1)
 * @tag BruteForce
 * @prb https://leetcode.com/problems/merge-sorted-array/description/
 */
public class Java_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }

        int idx_1 = m - 1;
        int idx_2 = n - 1;
        int curr_idx = m + n - 1;

        while (idx_1 >= 0 && idx_2 >= 0) {
            if (nums2[idx_2] >= nums1[idx_1]) {
                nums1[curr_idx--] = nums2[idx_2--];
            } else if (nums2[idx_2] < nums1[idx_1]) {
                nums1[curr_idx--] = nums1[idx_1--];
            }
        }

        while (idx_2 >= 0) {
            nums1[curr_idx--] = nums2[idx_2--];
        }
    }
}