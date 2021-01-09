package Easy;

import java.util.Arrays;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2020/12/28 10:11 下午
 * Description:
 */
public class Solution66 {

//    public int[] plusOne(int[] digits) {
//        int size = digits.length;
//        StringBuffer sb = new StringBuffer();
//        for (int i :
//                digits) {
//            sb.append(i);
//        }
//        int ordinaryDigit = Integer.parseInt(sb.toString());
//        String afterDigit = String.valueOf(ordinaryDigit + 1);
//        System.out.println(afterDigit);
//        char[] chars = afterDigit.toCharArray();
//        int[] result = new int[chars.length];
//        for (int i = 0; i < result.length; i++) {
//            int singleDigit = Integer.parseInt(String.valueOf(chars[i]));
//            System.out.println(singleDigit);
//            result[i] = singleDigit;
//        }
//
//        return result;
//    }

    public int[] plusOne(int[] digits) {
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        solution66.plusOne(new int[]{9, 9});
    }
}
