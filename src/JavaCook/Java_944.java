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
public class Java_944{
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        // Up Right Down Left
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // Get rotten orange
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                // Get fresh orange
                if(grid[i][j] == 1){
                    fresh +=1;
                }
            }
        }

        if(fresh == 0) return 0;

        int mins = 0;

        while(!queue.isEmpty()){
            int currSize = queue.size();
            mins++;

            for(int i = 0 ; i < currSize;i++){
                int[] rottenOrange = queue.poll();
                int r = rottenOrange[0];
                int c = rottenOrange[1];

                for(int[] direction : directions){
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr,nc});

                        if(fresh == 0){
                            return mins;
                        }
                    }
                }

            }
        }
        return -1;
    }

    /**
     * Google L4
     */
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    private static final int[][] DIRECTIONS = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    private static class Position {
        final int row;
        final int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting_google_l4(int[][] grid) {
        // 1. Boundary Guard - better to write it even it already told you m n > 1
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Deque<Position> queue = new ArrayDeque<>();

        // 2. Initialize rotten oranges queue and fresh oranges count
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.offer(new Position(r, c));
                } else if (grid[r][c] == FRESH) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int minutesElapsed = 0;

        // 3. Multi-source BFS
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                Position current = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int nextRow = current.row + dir[0];
                    int nextCol = current.col + dir[1];

                    // Check bounds and state
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                            && grid[nextRow][nextCol] == FRESH) {

                        grid[nextRow][nextCol] = ROTTEN;
                        freshCount--;
                        queue.offer(new Position(nextRow, nextCol));

                        // Early exit when all fresh oranges are rotted
                        if (freshCount == 0) {
                            return minutesElapsed + 1;
                        }
                    }
                }
            }
            minutesElapsed++;
        }

        return -1;
    }
}