package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/11 11:28 上午
 * Description:
 */
public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (String s :
                word1) {
            sb1.append(s);
        }
        for (String s :
                word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
