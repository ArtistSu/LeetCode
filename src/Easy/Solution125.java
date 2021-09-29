package Easy;

import java.util.*;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/11 10:13 上午
 * Description:
 */
public class Solution125 {
    public static void main(String[] args) {
        Solution125 s = new Solution125();
        s.isPalindrome2("0P");
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        Deque<Character> result = new LinkedList<>();
        for (char c :
                chars) {
            if ((c >= 97 && c <= 122) || (c>=48 && c<=57)) {
                result.add(c);
            }
        }
        int size = result.size() / 2;
        for (int i = 0; i < size ; i++) {
            if (result.pollFirst() != result.pollLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuffer sb  = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuffer sb_rev = new StringBuffer(sb).reverse();
        return sb.toString().equals(sb_rev.toString());
    }

    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
