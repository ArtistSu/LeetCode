package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity $$O\left(k \cdot \binom{9}{k}\right)$$
 * @SpaceComplexity O(1)
 */
public class Java_216 {
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;

    public List<List<Integer>> combinationSum3_google_l4(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        // Defensive check
        if (k < 0 || n < 0) return res;

        int minPossibleSum = k * (MIN_DIGIT + MIN_DIGIT + k - 1) / 2;
        int maxPossibleSum = k * (MAX_DIGIT + MAX_DIGIT - k + 1) / 2;

        if (n < minPossibleSum || n > maxPossibleSum) return res;

        dfs(MIN_DIGIT, k, n, 0, res, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int digit, int k, int n, int tempSum, List<List<Integer>> res, List<Integer> combination) {
        if (tempSum == n && k == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (digit > MAX_DIGIT || k < 0 || tempSum > n) return;

        // Pick
        combination.add(digit);
        dfs(digit + 1, k - 1, n, tempSum + digit, res, combination);
        combination.remove(combination.size() - 1);

        // Unpick
        dfs(digit + 1, k, n, tempSum, res, combination);
    }
}