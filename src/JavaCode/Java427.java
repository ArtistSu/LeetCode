package JavaCode;

public class Java427 {
    /**
     * Time Complexity: O(n^2logn)
     * Spcae Complexity: O(logn)
     * @method recursion
     * @topic Construct Quad Tree
     * @author ArtistS
     * @param grid
     * @return
     */
    public MyNode construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid[0].length);

    }

    public MyNode dfs(int[][] grid, int r0, int c0, int rn, int cn){
        boolean same = true;
        for(int i = r0; i < rn; ++i){
            for(int j = c0; j < cn; ++j){
                if(grid[i][j] != grid[r0][c0]){
                    same = false;
                    break;
                }
            }
            if(!same){
                break;
            }
        }
        if(same){
            return new MyNode(grid[r0][c0] == 1, true);
        }

        MyNode res = new MyNode(
                true,
                false,
                dfs(grid, r0, c0, (r0+rn)/2, (c0+cn)/2),
                dfs(grid, r0, (c0+cn)/2, (r0+rn)/2, cn),
                dfs(grid, (r0+rn)/2, c0, rn, (c0+cn)/2),
                dfs(grid, (r0+rn)/2, (c0+cn)/2, rn, cn)
        );
        return res;
    }
}

class MyNode {
    public boolean val;
    public boolean isLeaf;
    public MyNode topLeft;
    public MyNode topRight;
    public MyNode bottomLeft;
    public MyNode bottomRight;


    public MyNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public MyNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public MyNode(boolean val, boolean isLeaf, MyNode topLeft, MyNode topRight, MyNode bottomLeft, MyNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

