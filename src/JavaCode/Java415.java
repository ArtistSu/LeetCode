package JavaCode;

public class Java415 {
    /**
     * Time Complexity: O(n) {@code n} is the max value between num1.length() and num2.length()
     * Space Complexity: O(n)
     * @topic Add Strings
     * @author ArtistS
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int ptrA = num1.length() - 1, ptrB = num2.length() - 1, extra = 0;
        StringBuilder sb = new StringBuilder();
        while (ptrA >= 0 || ptrB >= 0 || extra != 0) {
            int x = ptrA >= 0 ? num1.charAt(ptrA--) - '0' : 0;
            int y = ptrB >= 0 ? num2.charAt(ptrB--) - '0' : 0;
            int res = x + y + extra;
            extra = res >= 10 ? 1 : 0;
            sb.insert(0, res % 10);
        }
        return sb.toString();
    }
}
