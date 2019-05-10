package Easy;

import java.util.HashMap;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-09 09:55
 */
public class Main {
    public static void main(String[] args) {
        String a = "123";
        String b = "12345";
        String c = "67890";
        System.out.println(c.indexOf(a
        ));
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(new String[]{"1","12","123"}));

    }
}
