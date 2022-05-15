package JavaCode;

public class Java883 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Projection Array of 3D Sahpes
     * @author ArtistS
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
        int top = 0, front =0, side = 0;
        int n = grid.length;
        for(int i=0; i < n; i++){
            int frontTemp =0, sideTemp = 0;
            for(int j =0; j < n;j++){
                top += grid[i][j] > 0 ? 1:0;
                frontTemp = Math.max(frontTemp, grid[i][j]);
                sideTemp = Math.max(sideTemp, grid[j][i]);
            }
            front += frontTemp;
            side += sideTemp;
        }
        return top + front + side;
    }
}
