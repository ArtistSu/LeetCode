package JavaCode;

import java.util.Arrays;

public class Java1051 {
    /**
     * Time Complexity: O(logn)+O(n) {@code n} is the length of{@params heights}
     * Space Complexity: O(n)
     * @method QuickSort
     * @topic Height Checker
     * @author ArtistS
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] heights_order = heights.clone();
        Arrays.sort(heights_order);
        int res = 0;
        for(int i = 0; i < heights.length;i++){
            if(heights[i] != heights_order[i]){
                res+=1;
            }
        }
        return res;
    }
}
