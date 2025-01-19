package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag Fermat'sLittleTheorem FastPower
 * @prb https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/description/
 * Time complexity: O(n log n + n × k)
 * Space complexity: O(n)
 */
public class Java_3428 {
    public static final int mod = (int) 1e9 + 7;
    public static long[] fact;
    public static long[] inv;

    public static void precomputeFactorials(int n) {
        fact = new long[n + 1];
        inv = new long[n + 1];
        fact[0] = 1;
        // Calculate factorial
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        inv[n] = fastPower(fact[n], mod - 2, mod);
        for (int i = n - 1; i >= 0; i--) {
            inv[i] = (inv[i + 1] * (i + 1)) % mod;
        }
    }

    public static long fastPower(long fact, long mod_2, int mod) {
        long inv_fact = 1;
        // let fact(a) < mod(p)
        fact = fact % mod;
        while (mod_2 > 0) {
            // The least digit is 1 or not
            if ((mod_2 & 1) == 1) {
                inv_fact = (inv_fact * fact) % mod;
            }
            mod_2 = mod_2 >> 1;
            fact = (fact * fact) % mod;
        }
        return inv_fact;
    }

    public static long nCr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        // n! / (r!*(n-r)!) = n! / r! * ((n-r)^-1)!
        return (fact[n] * inv[r] % mod * inv[n - r]) % mod;
    }

    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        precomputeFactorials(n);

        long sum = 0;
        // Eeach element is nums[i]
        for (int i = 0; i < n; i++) {
            long val = 0;
            int rightSideNum = n - 1 - i;

            for (int j = 0; j < k && j <= i; j++) {
                val = (val + nCr(i, j)) % mod;
            }
            sum = (sum + (val * nums[i]) % mod) % mod;
            val = 0;
            for (int j = 0; j < k && j <= rightSideNum; j++) {
                val = (val + nCr(rightSideNum, j)) % mod;
            }
            sum = (sum + (val * nums[i]) % mod) % mod;
        }
        return (int) sum;
    }
}

/**
 * 1. Get how many gaps after you can the exactly k indices where arr[i] == arr[i-1];
 * n digits will have n-1 gaps, each above pair will reduce 1 gap, so the number of gaps after k pairs
 * should be n-k-1
 * <p>
 * 2. Base we get the number of gaps, how many buckets we can re-order. Example:
 * 5 _ 1 1 _ 3 _ 2 2 _ 4
 * The above example we have 4 gaps which I use _ to represent. And we have 5 buckets which are
 * [5] [1 1] [3] [2 2] [4]
 * so the number of buckets is n-k-1+1 = n-k
 * <p>
 * 3. How to re-order them let them satisfy to the requirement? Let's use the above example
 * each element is in [1,m] so the first place I can put any element in [1,m], so there are m possibility
 * , what we should fill in next bucket? The value in next bucket should exclude the value you put in the
 * previous bucket, so it has m-1 possibility, by the same token, the following buckets all have m-1
 * possibility.
 * [m] [m-1] [m-1] [m-1] [m-1]
 * Totally we have m*(m-1)^(n-k-1) possibility
 * <p>
 * 4. But the above strategy  we ignore the following case if n = 4, k = 2
 * [1,1,1,2] which also satisfy the requirement
 * The above case it has 3 gaps (n-1), and if k = 2, we need to give on one divider to let them become
 * 2 buckets
 * so we have C(n-1)(k-1) possibility. -> not correct
 * You may have a question how about [1,1,1,2,1,1,1] k=4
 * 1st case we talk about one bucket has one pair at most
 * 2nd case we take about one bucket has 2 pairs
 * <p>
 * so the final formula should be C(n-1)(b-1), b is the number of buckets.The value of b should in [1,n-k-1]
 * If b = n-k, we can refer to case1.
 * <p>
 * 5.
 * The number of minimum should be nums[i] × ∑(j=0 to min(k,n-i-1)) C(n-i-1,j)
 * The number of maximum should be nums[i] × ∑(j=0 to min(k,i)) C(i,j)
 * The final formula should be m*(m-1)^(n-k-1) + nums[i] × ∑(j=0 to min(k,n-i-1)) C(n-i-1,j)
 * + nums[i] × ∑(j=0 to min(k,i)) C(i,j)
 */