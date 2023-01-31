package JavaCode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Java200 {
    /**
     * @param grid
     * @topic: Number of Islands
     * Time complexity: O(n2)
     * Space Complexity: min o(1) max o(mn)
     * @author: AtristS
     * @method: BFS
     */
    public int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    Queue<Pair<Integer, Integer>> neighbour = new LinkedList<>();
                    Pair<Integer, Integer> pair = new Pair(i, j);
                    neighbour.add(pair);
                    while (!neighbour.isEmpty()) {
                        Pair island = neighbour.poll();
                        int x = (int) island.getKey();
                        int y = (int) island.getValue();
                        if (x > 0 && grid[x - 1][y] == '1') {
                            neighbour.add(new Pair<Integer, Integer>(x - 1, y));
                            grid[x - 1][y] = '0';
                        }

                        if (x < m - 1 && grid[x + 1][y] == '1') {
                            neighbour.add(new Pair<Integer, Integer>(x + 1, y));
                            grid[x + 1][y] = '0';
                        }
                        if (y > 0 && grid[x][y - 1] == '1') {
                            neighbour.add(new Pair<Integer, Integer>(x, y - 1));
                            grid[x][y - 1] = '0';
                        }
                        if (y < n - 1 && grid[x][y + 1] == '1') {
                            neighbour.add(new Pair<Integer, Integer>(x, y + 1));
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * @param grid
     * @return
     * @title: Number of Islands
     * BFS (Breadth-first-Search)
     * Time complexity: O(n2)
     * Space Complexity: min o(1) max o(mn)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++nums;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {

                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {

                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {

                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {

                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }

            }
        }
        return nums;
    }

}
