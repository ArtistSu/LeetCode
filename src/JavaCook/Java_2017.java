package JavaCook;

/**
 * @author ArtistS
 * @tag Array Matrix PrefixSum
 * @prb https://leetcode.com/problems/grid-game/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2017{
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        for(int num : grid[0]){
            firstRowSum += num;
        }

        long secondRowSum = 0;
        long minVal = Long.MAX_VALUE;
        for(int turnIdx = 0; turnIdx <grid[0].length;turnIdx++){
            firstRowSum -= grid[0][turnIdx];
            minVal = Math.min(minVal, Math.max(firstRowSum,secondRowSum));
            secondRowSum += grid[1][turnIdx];
        }
        return minVal;
    }
}
/**
 * minVal = Math.min(minVal, Math.max(firstRowSum,secondRowSum));
 *
 * The matrix should look like
 *
 * [first row left part]  turnIdx [first row right part]
 * [second row left part] turnIdx [second row left part]
 *
 * caz the robot can only move right or down, so the sum points of 2nd robot only 2 choice
 * Option 1 -> 1st row right part
 * Option 2 -> 2nd row left part
 *
 * Math.max(firstRowSum,secondRowSum) -> can get the max value of these 2 parts
 *
 * But we need 1st robot get max points, so the above value must as small as they can. Therefor we
 * can let 1st get max points meanwhile, 2nd get the max value base on the rest of points.
 */