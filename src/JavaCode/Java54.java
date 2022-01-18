package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class Java54 {
    /**
     * Time Complexity : O(mn)
     * Space Complexity : O(1)
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
    /**
     * Time Complexity : O(mn)
     * Space Complexity : O(1)
     *
     * @param matrix
     * @return
     */

    int m = 0;
    int n = 0;

    // coordinate
    int x = 0;
    int y = -1;

    public void baseMove(int direction) {
        if (direction == 4) {
            y += 1;
        }
        if (direction == 2) {
            x += 1;
        }
        if (direction == 3) {
            y -= 1;
        }
        if (direction == 1) {
            x -= 1;
        }

    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        m = matrix[0].length;
        n = matrix.length;
        List<Integer> result = new ArrayList<>();

        // stimulate direction 1 -> up 2 -> down 3 -> left 4 right
        //int direction = 4;

        int step = 0;
        int circle = 0;

        while (step != m * n) {
            for (int i = 0; i < m - circle; i++) {
                baseMove(4);
                result.add(matrix[x][y]);
            }
            step += m - circle;
            if (step == m * n) {
                break;
            }

            for (int i = 0; i < n - 1 - circle; i++) {
                baseMove(2);
                result.add(matrix[x][y]);
            }
            step += n - 1 - circle;
            if (step == m * n) {
                break;
            }

            for (int i = 0; i < m - 1 - circle; i++) {
                baseMove(3);
                result.add(matrix[x][y]);
            }
            step += m - 1 - circle;
            if (step == m * n) {
                break;
            }

            for (int i = 0; i < n - 2 - circle; i++) {
                baseMove(1);
                result.add(matrix[x][y]);
            }
            step += n - 2 - circle;
            if (step == m * n) {
                break;
            }
            circle += 2;
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        new Java54().spiralOrder(arr);

    }
}
