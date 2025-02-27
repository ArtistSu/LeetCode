package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Array HashTable DynamicProgramming
 * @prb https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 * Time complexity: O(n^2) M is the largest number of arr
 * Space complexity: O(n)
 */
public class Java_873_2 {
    public int lenLongestFibSubseq(int[] arr) {
        int longest = 0;

        int[][] dp = new int[arr.length][arr.length];

        Map<Integer, Integer> valAndIndex = new HashMap<>();

        for (int curr = 0; curr < arr.length; curr++) {
            valAndIndex.put(arr[curr], curr);
            for (int prev = 0; prev < curr; prev++) {
                int diff = arr[curr] - arr[prev];
                int prevIndex = valAndIndex.getOrDefault(diff, -1);
                if (diff < arr[prev] && prevIndex >= 0) {
                    dp[prev][curr] = dp[prevIndex][prev] + 1;
                } else {
                    dp[prev][curr] = 2;
                }
                longest = Math.max(longest, dp[prev][curr]);
            }
        }
        return longest > 2 ? longest : 0;
    }

    public static void main(String[] args) {
        new Java_873_2().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }
}