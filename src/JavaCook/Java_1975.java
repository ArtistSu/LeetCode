package JavaCook;

/**
 * @author ArtistS
 * @tag Array Greedy Matrix
 * @prb https://leetcode.com/problems/maximum-matrix-sum
 * Time complexity:O(n) n is the number of elements in the matrix
 * Space complexity: O(1)
 */
public class Java_1975 {
    public long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        int sum = 0;
        int minAbsVal = Integer.MAX_VALUE;
        for(int[] row : matrix){
            for(int num : row){
                if( num <= 0){
                    negativeCount++;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(num));
                sum += Math.abs(num);
            }
        }
        if(negativeCount % 2 != 0){
            sum = sum - 2 * minAbsVal;
        }
        return sum;
    }

    public static void main(String[] args) {
        long maxMatrixSum = new Java_1975().maxMatrixSum(new int[][]{{1,2,3},{-1,-2,-3},{1,2,3}});
    }
}
