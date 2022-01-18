package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Java119 {
    /**
     * Title : Pascal's Triangle II
     * Formula
     * Time Complexity : O(rowIndex)
     * Space Complexity : O(1)
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    /**
     * Title : Pascal's Triangle II
     * BF method
     * Time Complexity : O(n2)
     * Space Complexity : O(1)
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[1];
        for (int i = 0; i <= rowIndex; i++) {
            int[] currArr = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    currArr[j] = 1;
                    continue;
                }
                currArr[j] = arr[j - 1] + arr[j];
            }
            arr = currArr;
        }
        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return result;
    }
}
