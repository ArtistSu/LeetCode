package JavaCook;


/**
 * @author ArtistS
 * @tag Array Math DynamicProgramming PrefixSum
 * @prb https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_1524 {
    public int numOfSubarrays(int[] arr) {
        final int MOD = (int) (1e9 + 7);
        int count = 0, prefixSum = 0;

        int oddCount = 0, evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            if ((prefixSum & 1) != 1) {
                count += oddCount;
                evenCount++;
            } else {
                count += evenCount;
                oddCount++;
            }
            count %= MOD;
        }
        return count;
    }
}