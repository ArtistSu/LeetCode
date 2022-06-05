package JavaCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Java52 {

    /**
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     * @method back track
     * @topic N Queens II
     * @author ArtistS
     * @param n
     * @return
     */
    int res = 0;
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diags1 = new HashSet<>();
        Set<Integer> diags2 = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backTrack(queens, n, 0, diags1, diags2, columns);
        return res;
    }

    public void backTrack(int[] queens, int n, int row, Set<Integer> diags1, Set<Integer> diags2, Set<Integer> columns) {
        if (row == n) {
            res++;
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diag1 = row - i;
                if (diags1.contains(diag1)) {
                    continue;
                }
                int diag2 = row + i;
                if (diags2.contains(diag2)) {
                    continue;
                }
                queens[row] = i;
                diags1.add(diag1);
                diags2.add(diag2);
                columns.add(i);
                backTrack(queens, n, row + 1, diags1, diags2, columns);
                queens[row] = -1;
                diags1.remove(diag1);
                diags2.remove(diag2);
                columns.remove(i);
            }
        }
    }
}
