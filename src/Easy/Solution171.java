package Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/28 8:41 下午
 * Description:
 */
public class Solution171 {
    //65-90 -> 64-89
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public int titleToNumber2(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += ((s.charAt(i) - 65) + 1) * Math.pow(26, (s.length() - 1 - i));
        }
        return num;
    }
}
