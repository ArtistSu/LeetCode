package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_909 {
    /**
     * @TimeComplexity O(n * n) n is the length of board
     * @SpaceComplexity O(n * n)
     */
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return -1;

        int n = board.length;
        int target = n * n;

        boolean[] visited = new boolean[target + 1];
        visited[1] = true;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int id = queue.poll();

                if (id == target) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = id + dice;

                    // next can equal to target
                    if (next > target) break;

                    int[] rc = getCoord(next, n);
                    int r = rc[0];
                    int c = rc[1];

                    int destination = (board[r][c] == -1) ? next : board[r][c];
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private int[] getCoord(int id, int n) {
        int rowFromBottom = (id - 1) / n;
        int r = n - 1 - rowFromBottom;

        int colFromLeft = (id - 1) % n;
        int c = (rowFromBottom % 2 == 0) ? colFromLeft : n - 1 - colFromLeft;
        return new int[]{r, c};
    }
}