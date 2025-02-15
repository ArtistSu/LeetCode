package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag backtracking math
 * @prb https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/
 * Time complexity:O(n*2^(logn))
 * Space complexity:O(nlogn)
 */
public class Java_2698{
    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int currNum = 1; currNum <= n; currNum++){
            int squareNum = currNum * currNum;
            String stringNum = Integer.toString(squareNum);

            // How many digits in squareNum & [0,currNum]
            int[][] memoArr = new int[stringNum.length()][currNum+1];
            for(int[] row : memoArr){
                Arrays.fill(row,-1);
            }

            if(findPartitions(0,0,stringNum,currNum,memoArr)){
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }

    public boolean findPartitions(int startIndex, int sum, String stringNum, int target, int[][] memo){
        if(startIndex == stringNum.length()){
            return sum == target;
        }

        if(sum > target) return false;

        if(memo[startIndex][sum] != -1) return memo[startIndex][sum] == 1;

        boolean partitionFound = false;

        /**
         * Iterate through all possible substrings starting with startIndex
         * e.g. 1234 startIndex=1 so it will iterate 2 23 234
         */
        for(int currentIndex = startIndex; currentIndex < stringNum.length(); currentIndex++){
            String currentString = stringNum.substring(startIndex, currentIndex+1);
            int addend = Integer.parseInt(currentString);

            partitionFound = partitionFound || findPartitions(currentIndex+1,sum+addend,stringNum,target,memo);

            if(partitionFound){
                memo[startIndex][sum] = 1;
                return true;
            }
        }

        memo[startIndex][sum] = 0;
        return false;
    }
}