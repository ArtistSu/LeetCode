package JavaCode;

public class Java829 {
    /**
     * Time Complexity: O(n^0.5) {@param n}
     * Space Complexity: O(1)
     * @method math
     * @topic Consecutive Numbers Sum
     * @author ArtistS
     * @param n
     * @return
     */
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1; i * (i + 1) / 2 <= n; i++) {
            if ((n - (i * (i + 1) / 2)) % i == 0) count++;
        }
        return count;
    }

}
