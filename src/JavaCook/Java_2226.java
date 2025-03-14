package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch
 * @prb https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class Java_2226 {
    public int maximumCandies(int[] candies, long k) {
        // Cant ensure each child get one candy
        long sum = 0;
        int right = 0;
        for (int candy : candies) {
            sum += candy;
            right = Math.max(right, candy);
        }
        if (sum < k) return 0;

        int left = 1;
        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (canAllocate(middle, candies, k)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public boolean canAllocate(int fixCandy, int[] candies, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / fixCandy;
            if (count >= k) return true;
        }
        return false;
    }
}