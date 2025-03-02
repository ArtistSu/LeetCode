package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag Array HashTable TwoPointers
 * @prb https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
 * Time complexity: O(n)
 * Space complexity: O(n+m) n is the length of nums1, m is the length of nums2
 */
public class Java_2570{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int point1 = 0, point2 = 0,index = 0;
        int[][] res = new int[nums1.length+nums2.length][2];


        while(point1 < nums1.length && point2 < nums2.length){
            if(nums1[point1][0] == nums2[point2][0]){
                res[index][0] = nums1[point1][0];
                res[index][1] = nums1[point1][1] + nums2[point2][1];
                point1++;
                point2++;
            }else if(nums1[point1][0] < nums2[point2][0]){
                res[index][0] = nums1[point1][0];
                res[index][1] = nums1[point1][1];
                point1++;
            }else{
                res[index][0] = nums2[point2][0];
                res[index][1] = nums2[point2][1];
                point2++;
            }
            index++;
        }

        while(point1 < nums1.length){
            res[index][0] = nums1[point1][0];
            res[index][1] = nums1[point1][1];
            point1++;
            index++;
        }

        while(point2 < nums2.length){
            res[index][0] = nums2[point2][0];
            res[index][1] = nums2[point2][1];
            point2++;
            index++;
        }

        return Arrays.copyOf(res,index);
    }

    public static void main(String[] args) {
        new Java_2570().mergeArrays(new int[][]{{1,2},{2,3},{4,5}},new int[][]{{1,4},{3,2},{4,1}});
    }
}