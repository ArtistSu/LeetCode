package JavaCode;

import java.util.Arrays;

public class Java88 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic: Merged Sorted Array
     * @author: ArtistS
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1, j = m -1, k = n - 1;
        while(k >= 0){
            if(j>=0 && nums1[j]>=nums2[k]){
                nums1[i--]=nums1[j--];
            }else{
                nums1[i--]=nums2[k--];
            }
        }
    }

}
