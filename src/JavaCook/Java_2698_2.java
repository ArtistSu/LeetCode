package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag backtracking math
 * @prb https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/
 * Time complexity:O(n*2^(logn))
 * Space complexity:O(logn)
 */
public class Java_2698_2 {
    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int currNum = 1; currNum <= n; currNum++){
            int squareNum = currNum * currNum;
            if(canPartitions(squareNum,currNum)){
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }

    public boolean canPartitions(int squareNum, int target){
        if(squareNum < target || target < 0){
            return false;
        }

        if(squareNum == target){
            return true;
        }

        return canPartitions(squareNum/10, target-squareNum%10) ||
                canPartitions(squareNum/100, target-squareNum%100) ||
                canPartitions(squareNum/1000, target-squareNum%1000);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}