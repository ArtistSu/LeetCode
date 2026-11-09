package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * Time complexity:
 * Space complexity:
 */
public class Java_172 {
    /**
     * Time complexity: O(log_5(n))
     * Space complexity: O(1)
     */
    public int trailingZeroes_google_l4(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
