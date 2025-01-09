

import java.util.LinkedList;
import java.util.Queue;

public class IslandSolution {
    private static int islandNo = 0;

    public int numIslands(char[][] grid) {
        int[][] isVisit = new  int[grid.length][grid[0].length];
        for (int x = 0; x <grid.length ; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if(isVisit[x][y]==1 || grid[x][y] == '0'){
                    continue;
                }
                dfs(grid,isVisit,x,y);
                IslandSolution.islandNo +=1;
            }
        }
        return islandNo;
    }

    public void dfs(char[][] grid,int[][] isVisit,int i,int j){
        if(i<grid.length&&j<grid[0].length){
            if(grid[i][j]=='1'){
                isVisit[i][j]=1;
                if(i<grid.length-1) {
                    if (isVisit[i + 1][j] == 0) {
                        dfs(grid, isVisit, i + 1, j);
                    }
                }
                if(j<grid[0].length-1) {
                    if (isVisit[i][j + 1] == 0) {
                        dfs(grid, isVisit, i, j + 1);
                    }
                }
                if(i>1) {
                    if (isVisit[i - 1][j] == 0) {
                        dfs(grid, isVisit, i - 1, j);
                    }
                }
                    if(j>1) {
                        if (isVisit[i][j - 1] == 0) {
                            dfs(grid, isVisit, i, j - 1);
                        }
                    }
            };
        };
    }

    public static void main(String[] args) {
        char[][] a = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        IslandSolution is = new IslandSolution();
        int num = is.numIslands(a);
        System.out.println("The number of islands is "+num);
    }

}



