package Easy;

import java.util.Stack;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-13 15:49
 * @Description
 */
public class Solution38 {
    public String countAndSay(int n) {
        StringBuilder current = new StringBuilder("1");
        StringBuilder previous;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            previous = current;
            current = new StringBuilder();
            count = 1;
            say = previous.charAt(0);

            for (int j = 1, length = previous.length(); j < length; j++) {
                if (previous.charAt(j) != say) {
                    current.append(count).append(say);
                    count = 1;
                    say = previous.charAt(j);
                } else {
                    count++;
                }
            }
            current.append(count).append(say);
        }
        return current.toString();

    }

}
