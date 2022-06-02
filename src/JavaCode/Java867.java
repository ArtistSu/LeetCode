package JavaCode;

public class Java867 {
    /**
     * Time Complexity: O(mn) {@code m} is the length of {@param matrix}, {@code n} is the length of {@param matrix[0]}
     * Space Complexity: O(mn)
     * @topic Transpose Matrix
     * @author ArtistS
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
