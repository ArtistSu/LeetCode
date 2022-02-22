package JavaCode;

public class Java389 {
    /**
     * Sum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param s
     * @param t
     * @returnchar
     * @author: AllenS
     */
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * Bit Operation
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int single = 0;
        for (int i = 0; i < s.length(); i++) {
            single ^= s.charAt(i);
        }
        return 'c';
    }

}
