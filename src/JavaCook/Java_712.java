package JavaCook;

/**
 * @author ArtistS
 * @tag String DP
 * @prb <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/?envType=daily-question&envId=2026-01-10">...</a>
 * @TimeComplexity O(n * m)
 * @SpaceComplexity O(n * m)
 */
public class Java_712{
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+s1.charAt(i);
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        int total = 0;
        for(char c : s1.toCharArray()) total += c;
        for(char c : s2.toCharArray()) total += c;
        return total - 2 * dp[n][m];
    }
}