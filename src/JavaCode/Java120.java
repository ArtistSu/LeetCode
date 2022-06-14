package JavaCode;

import java.util.List;

public class Java120 {
    /**
     * Time Complexity: O(n^2) {@code n} is the length of {@param triangle}
     * Space Complexity: O(n)
     * @method DP
     * @topic Triangle
     * @author ArtistS
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] res = new int[2][len];
        res[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            int curr = i % 2;
            int prev = 1 - curr;
            res[curr][0] = res[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                res[curr][j] = Math.min(res[prev][j-1], res[prev][j]) + triangle.get(i).get(j);
            }
            res[curr][i] = res[prev][i-1] + triangle.get(i).get(i);
        }
        int sum = res[(len-1)%2][0];
        for (int i = 1; i < len; ++i) {
            sum = Math.min(sum, res[(len-1)%2][i]);
        }
        return sum;
    }
    /**
     * Time Complexity: O(n^2) {@code n} is the length of {@param triangle}
     * Space Complexity: O(n^2)
     * @method DP
     * @topic Triangle
     * @author ArtistS
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] res = new int[len][len];
        res[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            res[i][0] = res[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                res[i][j] = Math.min(res[i - 1][j-1], res[i-1][j]) + triangle.get(i).get(j);
            }
            res[i][i] = res[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int sum = res[len - 1][0];
        for (int i = 1; i < len; ++i) {
            sum = Math.min(sum, res[len - 1][i]);
        }
        return sum;
    }
}
