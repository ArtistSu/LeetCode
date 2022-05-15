package JavaCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Java394 {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @topic Decode string
     * @author ArtistS
     * @param s
     * @return
     */
    int ptr;

    public String decodeString(String s) {
        ptr = 0;
        LinkedList<String> stack = new LinkedList<String>();
        while (ptr < s.length()) {
            char ch = s.charAt(ptr);
            if (Character.isDigit(ch)) {
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(ch) || ch == '[') {
                stack.addLast(String.valueOf(ch));
                ptr++;
            } else {
                ++ptr;
                LinkedList<String> temp = new LinkedList<String>();
                while (!"[".equals(stack.peekLast())) {
                    temp.addLast(stack.pollLast());
                }
                Collections.reverse(temp);
                stack.pollLast();

                int repTime = Integer.parseInt(stack.pollLast());
                StringBuffer newSB = new StringBuffer();
                String c = getString(temp);
                while (repTime-- > 0) {
                    newSB.append(c);
                }
                stack.addLast(newSB.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
