package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_289 {
    /**
     * @TimeComplexity O(M * N) M is the length of Array board, N is the length of Array board[0]
     * @SpaceComplexity O(1)
     */
    public void gameOfLife_google_l4(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;

        // State Machine
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Step 1: Compute next states and encode into the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                // Live & die in rows and cols
                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];

                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && ((board[newX][newY] & 1) == 1)) {
                        liveCount++;
                    }
                }

                // Rule evaluation: Determine if the cell will be alive in the next state
                if (board[i][j] == 1 && (liveCount == 2 || liveCount == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // Step 2: Final transition to update the board to the new state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}