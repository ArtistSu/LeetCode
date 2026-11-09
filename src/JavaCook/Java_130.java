package JavaCook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_130{
    /**
     * @TimeComplexity O(m * n)
     * @SpaceComplexity O(m * n)
     */
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };

    private static final char SAFE_MARKER = '#';
    private static final char VISITED_O = 'O';
    private static final char CAPTURED_X = 'X';

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == VISITED_O) bfs(board, i, 0);
            if (board[i][n - 1] == VISITED_O) bfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == VISITED_O) bfs(board, 0, j);
            if (board[m - 1][j] == VISITED_O) bfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == SAFE_MARKER) {
                    board[i][j] = VISITED_O;
                } else if (board[i][j] == VISITED_O) {
                    board[i][j] = CAPTURED_X;
                }
            }
        }
    }

    private void bfs(char[][] board, int startRow, int startCol) {
        int m = board.length;
        int n = board[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        board[startRow][startCol] = SAFE_MARKER;

        while (!queue.isEmpty()) {
            int[] site = queue.poll();
            int r = site[0];
            int c = site[1];

            for (int[] direction : DIRECTIONS) {
                int newX = r + direction[0];
                int newY = c + direction[1];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n || board[newX][newY] != VISITED_O) {
                    continue;
                }

                board[newX][newY] = SAFE_MARKER;
                queue.offer(new int[]{newX, newY});
            }
        }
    }
}