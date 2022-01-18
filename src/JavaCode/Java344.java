package JavaCode;

public class Java344 {
    /**
     * Two pointers techniques
     * Time Complexity : O(n / 2)
     * Space Complexity : O(1)
     * @param s
     */
    public void reverseString(char[] s) {
        // traversal the array s, the times is s.length / 2
        for (int i = 0; i < (s.length / 2); i++) {
            char tempCh = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tempCh;
        }
    }

}
