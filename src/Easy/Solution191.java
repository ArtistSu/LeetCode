package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/2/13 11:40 上午
 * Description:
 */
public class Solution191 {

    /*
     * This is a wrong function. You need to know if you input the binary as n, it will convert to
     * decimalism automatically.
     */
//    public int hammingWeight(int n) {
//        String s = String.valueOf(n);
//        int count = 0;
//        char[] chars = s.toCharArray();
//        for (char c :
//                chars) {
//            if(c == '1'){
//                count +=1;
//            }
//        }
//        return count;
//    }

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            count += 1;
            n &= (n -1);
        }
        return count;
    }


}
