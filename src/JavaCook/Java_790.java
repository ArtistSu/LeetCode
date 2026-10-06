package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_790{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public int numTilings_google_l4_hire(int n) {
        if(n <= 2) return n;

        long MOD = 1_000_000_007;
        long[][] dp = new long[n+1][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 2;
        dp[2][1] = 1;

        for(int i = 3; i <=n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1]) % MOD;
            dp[i][1] = (dp[i-1][1] + dp[i-2][0]) % MOD;
        }

        return (int) dp[n][0];
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int numTilings_google_l4(int n) {
        if(n <= 2) return n;

        final long MOD = 1_000_000_007;
        long prevTwoFull = 1; // dp[i - 2][0]
        long prevOneFull = 2; // dp[i - 1][0]
        long prevOnePart = 1; // dp[i - 1][1]

        for(int i = 3; i <=n; i++){
            long currFull = (prevOneFull + prevTwoFull + 2 * prevOnePart) % MOD;
            long currPart = (prevOnePart + prevTwoFull) % MOD;

            prevTwoFull = prevOneFull;
            prevOneFull = currFull;
            prevOnePart = currPart;
        }

        return (int) prevOneFull;
    }
}