package JavaCode;

import java.util.*;

public class Java51 {
    /**
     * Time Complexity: O(n!) {@param n}
     * Space Complexity: O(n)
     * @method track back
     * @topic N Queens
     * @author ArtistS
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(res, queens, n, 0, columns, diagonals1, diagonals2);
        return res;

    }

    public void backtrack(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                //  3 个 continue 就是判断是否在一个斜线上
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                // 找到自己 合适的列 之后 把这个列加入到 3 个 continue 判断的 set 集合中 避免下一个 queen 在同一斜线上
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 找下一个 queen
                backtrack(res, queens, n, row + 1, columns, diagonals1, diagonals2);
                // 这地方的理解就是 直接跳到最后一个 Queen
                // 当前的 row 应该是 n-1 因为是数组, 如果 留的位置不能满足条件, 上面的 backtrack 不会运行, 也就是不会有 row == n
                // 此时就需要 把刚才运行的那个节点 变成初始值 -1 也要将 斜线判定中的 相关值去掉 再进行本轮的 for 循环 一共 n 次
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }

    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
