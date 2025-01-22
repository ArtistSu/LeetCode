package JavaCook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ArtistS
 * @tag Array BFS Matrix
 * @prb https://leetcode.com/problems/map-of-highest-peak/description
 * Time complexity:
 * Space complexity:
 */
public class Java_1765{
    public int[][] highestPeak(int[][] isWater) {
        int rowsLen = isWater.length;
        int columnsLen = isWater[0].length;
        int[][] height = new int[rowsLen][columnsLen];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < rowsLen; i++){
            for(int j = 0 ; j < columnsLen; j++){
                height[i][j] = -1;
                if(isWater[i][j] == 1){
                    height[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] central = queue.poll();
            int x = central[0];
            int y = central[1];
            for(int[] dir : directions){
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                if(new_x>=0 && new_y >= 0 && new_x < rowsLen && new_y < columnsLen && height[new_x][new_y] == -1){
                    height[new_x][new_y] = height[x][y] + 1;
                    queue.add(new int[]{new_x,new_y});
                }
            }
        }
        return height;
    }
}