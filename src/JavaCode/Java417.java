package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class Java417 {

    final int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int[][] heights;
    int m, n;

    /**
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     * @method dfs
     * @topic Pacific Atlantic Water Flow
     * @author ArtistS
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i< m;i++){
            dfs(i, 0, pacific);
        }
        for(int j = 1; j< n;j++){
            dfs(0, j, pacific);
        }
        for(int i = 0; i< m;i++){
            dfs(i, n-1, atlantic);
        }
        for(int j = 0; j< n;j++){
            dfs(m-1, j, atlantic);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    public void dfs(int rowNbr, int colNbr, boolean[][] ocean){
        if(ocean[rowNbr][colNbr]){
            return;
        }
        ocean[rowNbr][colNbr] = true;
        for(int[] dir : dirs){
            int newRowNum = rowNbr + dir[0];
            int newColNum = colNbr + dir[1];
            if(newRowNum >=0 && newRowNum < m && newColNum >=0 && newColNum < n && heights[newRowNum][newColNum] >= heights[rowNbr][colNbr]){
                dfs(newRowNum, newColNum, ocean);
            }
        }
    }

}
