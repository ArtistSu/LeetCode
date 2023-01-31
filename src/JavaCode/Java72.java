package JavaCode;

public class Java72 {
    /**
     * Time Complexity: O(n * m) {@param n} is the length of {@param word1}, {@param m} is the length of {@param word2}
     * Space Complexity: O(n*m)
     * @topic Edit Distance
     * @author ArtistS
     * @method DP
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            arr[0][i] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            arr[j][0] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = (word2.charAt(i - 1) == word1.charAt(j - 1)) ? arr[i - 1][j - 1] : Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), Math.min(arr[i - 1][j - 1], arr[i - 1][j])) + 1;
            }
        }
        return arr[n][m];
    }
}
