package JavaCode;

public class Java1332 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s}
     * Space Complexity: O(1)
     * @topic Remove Palindromic Subsequences
     * @author ArtistS
     * @param s
     * @return
     */
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
