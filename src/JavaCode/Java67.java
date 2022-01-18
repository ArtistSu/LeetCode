package JavaCode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Java67 {

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();


        int maxSize = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < maxSize; i++) {
            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;

            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }

        return String.valueOf(ans.reverse());
    }

}
