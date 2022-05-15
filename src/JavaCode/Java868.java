package JavaCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java868 {
    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     * @topic Binary Gap
     * @author ArtistS
     * @param n
     * @return
     */
    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

    public String convertToBinary(int positiveInteger) {
        List<Integer> res = new ArrayList<>();
        while (positiveInteger != 0) {
            int remainder = positiveInteger % 2;
            positiveInteger = positiveInteger / 2;
            res.add(remainder);
        }
        Collections.reverse(res);
        StringBuffer sb = new StringBuffer();
        for (int s : res) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Java868 j = new Java868();
        System.out.println(j.convertToBinary(11));
    }
}
