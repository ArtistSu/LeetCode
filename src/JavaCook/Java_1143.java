package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_1143{
    /**
     * @TimeComplexity O(m*n)
     * @SpaceComplexity O(m*n)
     */
    public int longestCommonSubsequence_google_l4_hire(String text1, String text2) {
        // Defensive check
        int m = text1.length(), n = text2.length();
        if(m == 0 || n == 0){
            return 0;
        }

        int[][] dp = new int[m+1][n+1];

        for(int r = 1; r <= m; r++){
            char ch1 = text1.charAt(r-1);
            for(int c = 1; c <= n; c++){
                char ch2 = text2.charAt(c-1);
                if(ch1 == ch2){
                    dp[r][c] = dp[r-1][c-1] + 1;
                }else{
                    dp[r][c] = Math.max(dp[r-1][c],dp[r][c-1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * @TimeComplexity O(m*n)
     * @SpaceComplexity O(Min(m,n))
     */
    public int longestCommonSubsequence_google_l5(String text1, String text2) {
        // Defensive check
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int m = text1.length(), n = text2.length();

        // Ensure that text2 is the shorter string to keep the space complexity at O(min(m, n))
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence_google_l5(text2, text1);
        }

        int[] dp = new int[n+1];

        for(int r = 1; r <= m; r++){
            char ch1 = text1.charAt(r-1);
            int prev = 0;
            for(int c = 1; c <= n; c++){
                char ch2 = text2.charAt(c-1);
                int temp = dp[c];
                if(ch1 == ch2){
                    dp[c] = prev + 1;
                }else{
                    dp[c] = Math.max(dp[c-1],dp[c]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}