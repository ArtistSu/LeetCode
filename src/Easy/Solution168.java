package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/26 8:54 上午
 * Description:
 */
public class Solution168 {
    //65-90 -> 64-89
    public String convertToTitle(int n) {
        if (n == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            n--;
            sb.append((char) ('A' + (n % 26)));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
