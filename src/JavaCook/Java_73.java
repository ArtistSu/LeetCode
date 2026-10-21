package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_73{
    /**
     * @TimeComplexity O(M*N) M is the length of Array matrix, N is the length of Array matrix[0]
     * @SpaceComplexity O(M+N)
     */
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] zeroRow = new int[m];
        int[] zeroCol = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = 1;
                    zeroCol[j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(zeroRow[i] == 1 || zeroCol[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * @TimeComplexity O(M*N) M is the length of Array matrix, N is the length of Array matrix[0]
     * @SpaceComplexity O(1)
     */
    public void setZeroes_google_l4(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        // 1. Check if first row is zero or not
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                isFirstRowZero = true;
                break;
            }
        }

        // 2. Check if first column is zero or not
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }

        // 3. Use first row and first column as marker arrays.
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 4. Update the matrix
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] =0;
            }
        }

        // 5. Handle the 1st row
        if(isFirstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // 6. Handle the 1st column
        if(isFirstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}