package JavaCode;

import java.util.Arrays;

public class Java88 {
    /**
     * Time Complexity: O(m+n) {@param m} {@param n}
     * Space Complexity: O(1)
     * @topic: Merged Sorted Array
     * @author: ArtistS
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptrA = m-1, ptrB = n-1;
        int tail = m+n-1;
        int curr;
        while(ptrA >= 0 || ptrB >= 0){
            if(ptrA == -1){
                curr = nums2[ptrB--];
            }else if(ptrB == -1){
                curr = nums1[ptrA--];
            }else if(nums1[ptrA] >= nums2[ptrB]){
                curr = nums1[ptrA--];
            }else{
                curr = nums2[ptrB--];
            }
            nums1[tail--] = curr;
        }
    }

}
