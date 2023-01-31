package JavaCode;

import java.util.Deque;
import java.util.LinkedList;

public class Java48 {

    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param matrix}
     * Space Complexity: O(1)
     * @topic: Rotate Image
     * @author: ArtistS
     * @method: Formula
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param matrix}
     * Space Complexity: O(n^2)
     * @topic: Rotate Image
     * @author: ArtistS
     * @method: Deque
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                deque.offerLast(matrix[i][j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[j][n-i-1] = deque.pollFirst();
            }
        }
    }
}
