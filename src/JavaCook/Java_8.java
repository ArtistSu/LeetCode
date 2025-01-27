package JavaCook;

/**
 * @author ArtistS
 * @tag String
 * @prb https://leetcode.com/problems/string-to-integer-atoi/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_8{
    public int myAtoi(String s) {
        String str = s.trim();
        if(str.length() == 0) return 0;

        int idx = 0;
        int sign = 1;

        if(str.charAt(0) == '-'){
            idx++;
            sign=-1;
        }else if(str.charAt(0) == '+'){
            idx++;
        }

        int res = 0;
        while(idx < str.length() && Character.isDigit(str.charAt(idx))){
            int digit = str.charAt(idx) - '0';
            if(res > (Integer.MAX_VALUE-digit) / 10){
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            idx++;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        //2147483647
        System.out.println(Integer.MAX_VALUE);

        new Java_8().myAtoi("   -042");
    }
}