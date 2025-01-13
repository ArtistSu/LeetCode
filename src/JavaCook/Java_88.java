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
        if(nums2.length == 0){
            return ;
        }

        int pointA = m-1;
        int pointB = n-1;
        int point = m+n-1;
        while( pointA >= 0 && pointB >= 0){
            if(nums2[pointB] > nums1[pointA]){
                nums1[point--] = nums2[pointB--];
            }else{
                nums1[point--] = nums1[pointA--];
            }
        }

        while(pointA >= 0){
            nums1[point--] = nums1[pointA--];
        }

        while(pointB >= 0){
            nums1[point--] = nums2[pointB--];
        }
    }
}