package JavaCook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/pascals-triangle/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class Java_118_2 {
    public List<Integer> generateRows(int row){
        int  ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for(int col = 1; col < row ; col++){
            ans = ans * (row - col) / col;
            ansRow.add(ans);
        }

        return ansRow;

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<= numRows ; i++){
            ans.add(generateRows(i));
        }

        return ans;
    }

}