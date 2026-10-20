package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_54{
    /**
     * @TimeComplexity O(M * N) M * N is the number of digits in Array matrix
     * @SpaceComplexity O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null) return new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;


        int steps = 0;
        int totalSteps = m * n;
        // right down left up
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0, y = 0;
        int redirect = 0;

        List<Integer> res = new ArrayList<>();
        res.add(matrix[x][y]);
        while(steps < totalSteps){
            int newX = x + directions[redirect % 4][0];
            int newY = y + directions[redirect % 4][1];

            if(newX == m || newY == n || newX == -1 || newY == -1 || matrix[newX][newY] == Integer.MAX_VALUE ){
                redirect++;
            }

            x = x + directions[redirect % 4][0];
            y = y + directions[redirect % 4][1];
            steps++;
            res.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
        }
        return res;
    }

    /**
     * @TimeComplexity O(M * N) M * N is the number of digits in Array matrix
     * @SpaceComplexity O(1)
     */
    public List<Integer> spiralOrder_google_l4(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while(top <= bottom && left <= right){
            for(int j = left; j <= right; j++){
                res.add(matrix[top][j]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int j = right; j >= left; j--){
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}