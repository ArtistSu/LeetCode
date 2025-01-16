package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/pascals-triangle-ii/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class Java_119{
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow;
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        if(rowIndex == 0){
            return currRow;
        }
        for (int i = 1; i <= rowIndex; i++){
            preRow = currRow;
            currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++){
                currRow.add(preRow.get(j-1)+preRow.get(j));
            }
            currRow.add(1);
        }

        return currRow;
    }
}