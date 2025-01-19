
import java.util.*;


public class test {
    private static final int MOD = 1_000_000_007;

    public static int sumOfMaxMin(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        // Precompute powers of 2 modulo MOD
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        long result = 0;

        // Iterate and compute max and min contributions
        for (int i = 0; i < n; i++) {
            long maxContrib = power[i];
            long minContrib = power[n - i - 1];

            // Update result using nums[i] as both max and min in subsequences
            result = (result + nums[i] * (maxContrib - minContrib + MOD)) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;
        System.out.println(sumOfMaxMin(nums, k)); // Expected output: 24
    }


}

