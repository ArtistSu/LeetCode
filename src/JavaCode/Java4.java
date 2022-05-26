package JavaCode;

public class Java4 {
    /**
     * Time Complexity: O(log(m+n)) {@ccode m} is the length of {@param nums1}, {@code n} is the length of {@param nums2}
     * Space Complexity: O(1)
     * @methor Binary Search
     * @topic Median of Two Sorted Arrays
     * @author ArtistS
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int k = (m+n)/2;
        if(totalLength % 2 == 0){
            return (findKthNumber(nums1, nums2, k) + (findKthNumber(nums1, nums2, k+1)))/2;
        }else{
            return findKthNumber(nums1, nums2, k+1);
        }
    }

    public double findKthNumber(int[] nums1, int[] nums2, int k){
        int index1 = 0, index2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        while(true){
            if(index1 == len1){
                return nums2[index2 + k - 1];
            }
            if(index2 == len2){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int middle = k / 2;
            int newIndex1 = Math.min(index1 + middle, len1) - 1;
            int newIndex2 = Math.min(index2 + middle, len2) - 1;
            int currValue1 = nums1[newIndex1];
            int currValue2 = nums2[newIndex2];
            if(currValue1 <= currValue2){
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
