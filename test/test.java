
import java.util.*;


public class test {
    public int longestPalindromicSubsequence(String s, int k) {
        int len = s.length();

        // Intialize dp[][][]
        int[][][] dpArr = new int[len][len][k+1];

        for(int i = 0; i < len; i++){
            for(int j = 0; j<= k; j++){
                dpArr[i][i][j] = 1;
            }
        }

        // Fill dpArr
// Nested loops for the dynamic programming approach
        for (int subLen = 2; subLen <= len; ++subLen) {  // Substring length
            for (int i = 0; i <= len - subLen; ++i) {
                int j = i + subLen - 1;
                for (int x = 0; x <= k; ++x) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dpArr[i][j][x] = 2 + dpArr[i + 1][j - 1][x];
                    } else {
                        int res1 = dpArr[i + 1][j][x];
                        int res2 = dpArr[i][j - 1][x];
                        int diff = diff(s.charAt(i), s.charAt(j));
                        int res3 = (x >= diff) ? 2 + dpArr[i + 1][j - 1][x - diff] : 0;

                        // Take the maximum of all options
                        dpArr[i][j][x] = Math.max(Math.max(res1, res2), res3);
                    }
                }
            }
        }
        return dpArr[0][len-1][k];
    }

    public int diff(char ch1, char ch2) {
        int diff = Math.abs(ch1 - ch2);
        return Math.min(diff, 26 - diff);
    }

    public static void main(String[] args) {
        new test().largestInteger(new int[]{3,9,2,1,7},3);
    }
}

