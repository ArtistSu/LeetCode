package JavaCode;

public class Java583 {
    /**
     * Time Complexity: O(m * n) {@code m} is the length of {@param word1}, {@code n} is the length of {@param word2}
     * Space Complexity: O(m * n)
     * @method DP
     * @topic Delete Operation for Two Strings
     * @author ArtistS
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] res = new int[m+1][n+1];
        for(int i = 1; i < n+1; i++){
            res[0][i] = i;
        }
        for(int i = 0; i < m+1; i++){
            res[i][0] = i;
        }

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j< n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    res[i][j] = res[i-1][j-1];
                }else{
                    res[i][j] = Math.min(res[i-1][j], res[i][j-1])+1;
                }
            }
        }
        return res[m][n];
    }
}
