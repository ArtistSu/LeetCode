package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class Java118 {
    /**
     * Time Complexity : O(numRows^2)
     * Space Complexity : O(n)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> levelList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j== i){
                    levelList.add(1);
                    continue;
                }
                int val1 = result.get(i - 1).get(j-1);
                int val2 = result.get(i - 1).get(j);
                levelList.add(val1 + val2);
            }
            result.add(levelList);
        }

        return result;
    }
}
