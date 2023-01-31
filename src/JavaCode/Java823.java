package JavaCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Java823 {
    /**
     * Time Complexity: O(n^2) {@param n} is the length of arr
     * Space Complexity: O(n)
     * @topic Binary Trees With Factors
     * @author ArtistS
     * @method dp
     * @param arr
     * @return
     */
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        int len = arr.length;
        Arrays.sort(arr);

        long[] dp = new long[len];
        Arrays.fill(dp,1);

        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < len; i++){
            index.put(arr[i],i);
        }

        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0){
                    int right = arr[i] / arr[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }
        return (int) (Arrays.stream(dp).sum() % MOD);
    }
}
