package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity O(log ( N))
 * @SpaceComplexity O(1)
 */
public class Java_374 {
    // This is mock guess, only avoid report error.
    public int guess(int num) {
        return -1;
    }

    public int guessNumber_google_l4(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res == 1) {
                left = mid + 1;  // 猜小了，往右找
            } else {
                right = mid - 1; // 猜大了，往左找
            }
        }

        return -1;
    }
}