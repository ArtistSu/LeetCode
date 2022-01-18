package JavaCode;

import java.util.LinkedList;
import java.util.Queue;

public class Java200 {

    /**
     * @title: Number of Islands
     * BFS (Breadth-first-Search)
     * Time complexity: O(n2)
     * Space Complexity: min o(1) max o(mn)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 ){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if(grid[r][c] == '1'){
                    ++nums;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while(!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if(row - 1 >= 0 && grid[row-1][col] == '1'){

                            neighbors.add((row - 1) * nc + col );
                            grid[row-1][col] = '0';
                        }
                        if(row + 1 < nr && grid[row+1][col] == '1'){

                            neighbors.add((row + 1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if(col - 1 >= 0 && grid[row][col-1] == '1'){

                            neighbors.add(row * nc + col - 1);
                            grid[row][col-1] = '0';
                        }
                        if(col + 1 < nc && grid[row][col+1] == '1'){

                            neighbors.add(row * nc + col + 1);
                            grid[row][col+1] = '0';
                        }
                    }
                }

            }
        }
        return nums;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        new Java200().numIslands(grid);

    }
}
