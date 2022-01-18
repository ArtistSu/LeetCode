package JavaCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Java557 {
    /**
     * Title : Reverse Words in a String III
     * Deque
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;
        Deque<String> queue = new ArrayDeque<>();
        StringBuffer word = new StringBuffer();
        while (left <= right) {
            char c = s.charAt(left);
            if (c == ' ' && word.length() != 0) {
                queue.offer(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.insert(0, c);
            }
            left++;
        }
        queue.offer(word.toString());
        return String.join(" ", queue);
    }

    /**
     * Title : Reverse Words in a String III
     * API
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strS = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strS.length; i++) {
            strS[i] = sb.append(strS[i]).reverse().toString();
            sb.setLength(0);
        }
        return String.join(" ", strS);
    }
}
