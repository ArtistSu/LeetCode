package JavaCode;

import java.util.*;

public class Java752 {
    /**
     * @title: Open the Lock
     * BFS
     * <p>
     * Time Complexity: O(b^d * d^2 + md) b -> number base d -> the number of circular wheel m -> the length of deadends
     * Space Complexity: O(b^d * d + m)
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Set<String> dead = new HashSet<>();
        for (String deadend :
                deadends) {
            dead.add(deadend);
        }
            if (dead.contains("0000")) {
                return -1;
            }

            int step = 0;
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            Set<String> seen = new HashSet<>();
            seen.add("0000");

            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String status = queue.poll();
                    for (String nextStatus :
                            get(status)) {
                        if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                            if (nextStatus.equals(target)) {
                                return step;
                            }
                            queue.offer(nextStatus);
                            seen.add(nextStatus);
                        }

                    }
                }
            }
            return -1;
        }

    public char numPrev(char x){
        return x == '0' ? '9' : (char)(x-1);
    }
    public char numSucc(char x){
        return x == '9' ? '0' : (char)(x+1);

    }

    public List<String> get(String status) {
        List<String> ret = new ArrayList<>();
        char[] arr = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = arr[i];
            arr[i] = numPrev(num);
            ret.add(new String(arr));
            arr[i] = numSucc(num);
            ret.add(new String(arr));
            arr[i] = num;
        }
        return ret;
    }
}
