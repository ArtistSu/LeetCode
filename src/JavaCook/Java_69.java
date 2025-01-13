package JavaCook;

/**
 * @author ArtistS
 * @tag BinarySearch
 * @prb https://leetcode.com/problems/sqrtx/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
/**
 * Why return right rather than left?
 * If you want to break the while loop, right must < left.
 * Before you break the loop, right * right > x
 * So after you break the loop, the res in [right, left], we want to get the round-down value,
 * so return right.
 */