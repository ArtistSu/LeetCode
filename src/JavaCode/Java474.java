package JavaCode;

public class Java474 {
    /**
     * Time Complexity: O(m*n*len + L) {@code L} is the number of all characters in {@param strs}
     * Space Complexity: O(m*n)
     * @method DP
     * @topic Ones and Zeroes
     * @author ArtistS
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <=len; i++){
            int[] zerosAndOnes = getZerosAndOnes(strs[i-1]);
            int zeros = zerosAndOnes[0], ones = zerosAndOnes[1];
            for(int j = m; j >= 0; j--){
                for(int k = n; k >= 0; k--){
                    if(j >= zeros && k >= ones){
                        dp[j][k] = Math.max(dp[j][k],dp[j-zeros][k-ones]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public int[] getZerosAndOnes(String str){
        int[] res = new int[2];
        for(int i = 0; i < str.length(); i++){
            res[str.charAt(i)-'0']+=1;
        }
        return res;
    }
}
