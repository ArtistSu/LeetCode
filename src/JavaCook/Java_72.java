package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_72{
    /**
     * @TimeComplexity O(m*n)
     * @SpaceComplexity O(m*n)
     */
    public int minDistance_google_l4_hire(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i <= m; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++){
            char ch1 = word1.charAt(i-1);
            for(int j = 1; j <= n; j++){
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    /**
     * @TimeComplexity O(m*n)
     * @SpaceComplexity O(Min(m,n))
     */
    public int minDistance_google_l4(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        if(n > m) return minDistance_google_l4(word2,word1);

        int[] dp = new int[n+1];

        // Use array rather than charAt to improve performance.
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for(int j = 0 ; j <= n; j++){
            dp[j] = j;
        }

        for(int i = 1; i <= m; i++){
            char ch1 = w1[i-1];
            int prev = dp[0];
            dp[0] = i;
            for(int j = 1; j <= n; j++){
                char ch2 = w2[j-1];
                int temp = dp[j];
                if(ch1 == ch2){
                    dp[j] = prev;
                }else{
                    dp[j] = Math.min(prev, Math.min(dp[j-1], dp[j])) + 1;
                }
                prev = temp;
            }
        }
        return dp[n];
    }

}