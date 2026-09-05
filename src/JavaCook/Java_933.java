package JavaCook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ArtistS
 * @tag Queue
 * @prb https://leetcode.com/problems/number-of-recent-calls/submissions/2132186429/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O（n）
 * @SpaceComplexity O(n)
 */
public class Java_933{
}

class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while(queue.peek() < t - 3000) queue.poll();

        return queue.size();
    }
}