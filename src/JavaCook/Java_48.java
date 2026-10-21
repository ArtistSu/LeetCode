package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_48{
    /**
     * @TimeComplexity O(N^2) N is the length of Array matrix
     * @SpaceComplexity O(1)
     */
    public void rotate_google_l4(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return ;

        int n = matrix.length;

        // 1. Transpose along the main diagonal (swap matrix[i][j] and matrix[j][i]).
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row from left to right
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}