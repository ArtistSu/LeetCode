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
public class Java_1926{
    public int nearestExit_google_l4(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        // Clarify the direction
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Deque<int[]> queue = new ArrayDeque<>();
        // x,y,steps
        queue.offer(new int[]{entrance[0],entrance[1],0});
        // Mark entrance as a wall
        maze[entrance[0]][entrance[1]] = '+';


        while(!queue.isEmpty()){
            int[] currentPos = queue.poll();
            int r = currentPos[0];
            int c = currentPos[1];
            int steps = currentPos[2];

            for(int[] direction: directions){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.'){
                    if(nr == 0 || nr == (m-1) ||nc == 0 || nc ==(n-1)){
                        return steps+1;
                    }

                    maze[nr][nc] = '+';
                    queue.offer(new int[]{nr,nc,steps+1});
                }
            }
        }
        return -1;
    }
}