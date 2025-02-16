package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag Greedy
 * @prb https://leetcode.com/problems/eat-pizzas/description/
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class Java_3457 {
    public long maxWeight(int[] pizzas) {
        long res = 0;
        int totalDays = pizzas.length / 4;
        int oddDays = (totalDays + 1) / 2;

        Arrays.sort(pizzas);

        for (int i = pizzas.length - 1, day = 1; day <= totalDays; i--, day++) {
            if (day > oddDays) i--;
            res += (long) pizzas[i];
        }
        return res;
    }
}