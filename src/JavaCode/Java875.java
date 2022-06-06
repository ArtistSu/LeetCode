package JavaCode;

public class Java875 {
    /**
     * Time Complexity: O(n logm) {@code n} is the length of {@param piles}, {@code m} is the max value in {@param piles}
     * Space Complexity: O(1)
     * @method Binary Search
     * @topic Koko Eating Bananas
     * @author ArtistS
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int k = right;
        while (left < right) {
            int speed = (left + (right - left) / 2);
            int time = getTime(piles, speed);
            if (time > h) {
                left = speed + 1;
            } else {
                right = speed;
                k = speed;
            }
        }
        return k;
    }

    public int getTime(int[] piles, int speed) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            if (speed >= piles[i]) {
                time++;
            } else {
                time += (int) Math.ceil((double) piles[i] / speed);
            }
        }
        return time;
    }
}
