package JavaCook;

import java.util.List;

/**
 * @author ArtistS
 * @tag Array BitMainpulation
 * @prb <a href="https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/description/?envType=daily-question&envId=2026-01-20">...</a>
 * @TimeComplexity O(nlogm)
 * @SpaceComplexity O(1)
 */
public class Java_3314 {
    // TimeComplexity:O(mn) SpaceComplexity:O(1)
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int ori = nums.get(i);
            int candidate = -1;
            for (int j = 1; j < ori; j++) {
                if ((j | (j + 1)) == ori) {
                    candidate = j;
                    break;
                }
            }
            ans[i] = candidate;
        }
        return ans;
    }

    public int[] minBitwiseArrayV2(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int res = -1;
            int d = 1;
            // Try to check if this bit is 0
            while ((x & d) != 0) {
                // If this bit not 0, try to make this bit in result to be 0
                res = x - d;
                // Binary from 1 to 10 or 100 or 1000 and so on
                d <<= 1;
            }
            result[i] = res;
        }
        return result;
    }
}