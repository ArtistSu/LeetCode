package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ArtistS
 * @tag Queue
 * @prb https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(n)
 * @SpaceComplexity O(n)
 */
public class Java_649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char curr = senate.charAt(i);
            if (curr == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                radiant.offer(r + n);
            } else {
                dire.offer(d + n);
            }
        }

        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}