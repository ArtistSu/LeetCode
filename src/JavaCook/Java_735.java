package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag Array Stack Simulation LC75
 * @prb <a href="https://leetcode.com/problems/asteroid-collision/solutions/5756593/video-using-stack-to-keep-asteroids-by-n-5jde/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(n)
 */
public class Java_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                // Collide
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}