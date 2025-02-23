package JavaCook;

import java.util.PriorityQueue;

/**
 * @author ArtistS
 * @tag PriorityQueue
 * @prb https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/
 * Time complexity: O(n∗m∗log(k))
 * Space complexity: O(k)
 */
public class Java_3462{
    public static long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> res = new PriorityQueue<int[]>((a,b) -> (b[0]-a[0]));

        // Push all elements into the priority queue with row number
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res.add(new int[]{grid[i][j],i});
            }
        }

        long sumVal = 0;
        while(k > 0){
            int[] ele = res.poll();
            if(limits[ele[1]] > 0){
                sumVal += ele[0];
                limits[ele[1]]--;
                k--;
            }
        }
        return sumVal;
    }
}