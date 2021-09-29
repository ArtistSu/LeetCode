package Easy;

import java.util.List;

/**
 * @author suyuelai
 * @version V1.0
 * @date 2020/12/14 5:47 下午
 * Description:
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        if(s == null ){
            return 0;
        }
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) ==  ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
                count++;
            }
        return count;
    }

    public static void main(String[] args) {
        Solution58 s58 = new Solution58();
        System.out.println(s58.lengthOfLastWord("a"));
    }
}
