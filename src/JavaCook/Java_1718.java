package JavaCook;

/**
 * @author ArtistS
 * @tag Backtracking
 * @prb https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/
 * Time complexity: O(n!)
 * Space complexity: O(1)
 */
public class Java_1718 {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] isNumberUsed = new boolean[n + 1];
        findLexicographicallyLargestSequence(0, res, isNumberUsed, n);
        return res;
    }

    public boolean findLexicographicallyLargestSequence(int currentIndex, int[] res, boolean[] isNumberUsed, int targetNumber) {
        // If we have filled all positions, return true indicating success
        if (currentIndex == res.length) return true;

        // If the current position is already filled, move to the next index
        if (res[currentIndex] != 0)
            return findLexicographicallyLargestSequence(currentIndex + 1, res, isNumberUsed, targetNumber);

        // Attempt to place numbers from targetNumber to 1 for a lexicographically largest result
        for (int numberToPlace = targetNumber; numberToPlace >= 1; numberToPlace--) {
            if (isNumberUsed[numberToPlace]) continue;
            isNumberUsed[numberToPlace] = true;
            res[currentIndex] = numberToPlace;

            if (numberToPlace == 1) {
                if (findLexicographicallyLargestSequence(currentIndex + 1, res, isNumberUsed, targetNumber))
                    return true;
            } else if (currentIndex + numberToPlace < res.length && res[currentIndex + numberToPlace] == 0) {
                res[currentIndex + numberToPlace] = numberToPlace;
                if (findLexicographicallyLargestSequence(currentIndex + 1, res, isNumberUsed, targetNumber))
                    return true;
                // Undo the placement for backtracking
                res[currentIndex + numberToPlace] = 0;
            }
            // Undo current placement and mark the number as unused
            res[currentIndex] = 0;
            isNumberUsed[numberToPlace] = false;
        }
        return false;
    }
}