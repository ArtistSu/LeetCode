package JavaCode;

import java.util.LinkedList;
import java.util.Queue;

public class Java933 {
    /**
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     * @topic Number of Recent Calls
     * @author ArtistS
     */
    Queue<Integer> recentRequests;
    public Java933() {
        recentRequests = new LinkedList<Integer>();
    }

    public int ping(int t) {
        recentRequests.offer(t);
        while (recentRequests.peek() < t - 3000) {
            recentRequests.poll();
        }
        return recentRequests.size();
    }
}
