package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag Array Sorting
 * @prb <a href="https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/description/?envType=daily-question&envId=2026-01-15">...</a>
 * @TimeComplexity: O(hlog(h) + vlog(v)) h and v are the lengths of hBars and vBars
 * @SpaceComplexity: O(log(h) + log(v))
 */
public class Java_2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // Find the longest consecutive integer values
        int hMax = findMaxConsecutiveNumber(hBars);
        int vMax = findMaxConsecutiveNumber(vBars);

        // Max square length
        int side = Math.min(hMax,vMax)+1;
        return side * side;
    }

    public int findMaxConsecutiveNumber(int[] bars){
        if (bars.length == 0) return 0;
        int max = 1, curr = 1;

        for(int i = 1; i < bars.length; i++){
            if(bars[i] == bars[i-1] + 1){
                curr++;
            }else{
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}