class Solution04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int leftVar = nums1[0];
        int rightVar = nums2[0];
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            leftVar = rightVar;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                rightVar  =  nums1[aStart++];
            }else{
                rightVar = nums2[bStart++];
            }
        }
        if ( (len & 1) == 0){
            return (leftVar+rightVar) /2.0;
        }else{
            return rightVar * 1.0;
        }
    }
}
