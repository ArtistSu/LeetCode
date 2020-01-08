
/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-09 09:56
 */
public class Solution7 {
    public int reverse(int x) {
        if(x<Integer.MIN_VALUE||x>Integer.MAX_VALUE) return 0;

        String digital = String.valueOf(x);
        char[] digitalArray = digital.toCharArray();
        int digitalLength = digitalArray.length;
        char[] resultArray = new char[digitalLength];

        for (int i = 0; i < digitalLength; i++) {
            if (digitalArray[0] == '-') {
                resultArray[i] = digitalArray[i];
                continue;
            }
            resultArray[digitalLength - 1 - i] = digitalArray[i];
        }
        String result = String.valueOf(resultArray);

        return Integer.parseInt(result);
    }

    public int reverse2(int x) {
        int rev = 0;
        if(x>Integer.MAX_VALUE) return 0;
        if(x<Integer.MIN_VALUE) return 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverseSolution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


}

