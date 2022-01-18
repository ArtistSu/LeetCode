package JavaCode;

import java.util.*;

public class Java151 {
    /**
     * Title : Reverse Words in a String
     * Deque
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right && s.charAt(left) == ' '){
            left++;
        }

        while(right >= left && s.charAt(right) == ' '){
            right--;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuffer sb = new StringBuffer();

        while(left <= right){
            char c = s.charAt(left);
            if((sb.length() != 0) && c == ' '){
                d.offerFirst(sb.toString());
                sb.setLength(0);
            }else if (c != ' '){
                sb.append(c);
            }
            left++;
        }
        d.offerFirst(sb.toString());
        return String.join(" ", d);
    }

    /**
     * Title : Reverse Words in a String
     * API
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();

        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);

        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        new Java151().reverseWords("  hello world  ");
    }
}
