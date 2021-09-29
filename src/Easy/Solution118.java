package Easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/9 6:12 下午
 * Description:
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        // initial the result list
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }


        result.add(new ArrayList<>());
        result.get(0).add(1);

        for(int numRow = 1; numRow < numRows; numRow++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(numRow-1);
            for (int j = 0; j <= numRow; j++) {
                if (j == 0 || j == numRow) {
                    row.add(1);
                    continue;
                }
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            result.add(row);
        }
        return result;
    }

}
