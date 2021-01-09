class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int gx = grid.length;
        int gy = grid[0].length;
        int num_islands = 0;
        for (int x = 0; x < gx; ++x) {
            for (int y = 0; y < gy; ++y) {
                if (grid[x][y] == '1') {
                    ++num_islands;
                    dfs(grid, x, y);
                }
            }
        }

        return num_islands;
    }
    public static void main(String[] args) {
        System.out.println(b'\xe6\x88\x91\xe7\x88\xb1\xe4\xbd\xa0'.decode('utf-8'));
    }
}
