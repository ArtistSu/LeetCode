package JavaCode;

public class Java59 {
    /**
     * Time Complexity: O(n) {@param n}
     * Space Complexity: O(n^2)
     * @topic Spiral Matrix II
     * @author ArtistS
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int currNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        while(currNum <= maxNum){
            matrix[row][column] = currNum;
            currNum++;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if(nextRow<0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0){
                directionIndex = (directionIndex+1)%4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }
}
