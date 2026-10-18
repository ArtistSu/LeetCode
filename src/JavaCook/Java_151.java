package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_151{
    /**
     * Reverses the words in a given string.
     *
     * @TimeComplexity  O(N) - where N is the length of the string s.
     *                         Traversing, trimming, splitting, and rebuilding all take linear time.
     * @SpaceComplexity O(N) - where N is the length of the string s.
     *                         The `trim()` and `split()` methods allocate a new String array
     *                         and new String objects in memory.
     */
    public String reverseWords_google_l4(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s2Array = s.strip().split("\\s+");

        int n = s2Array.length;

        for(int i = n - 1; i >= 0; i--){
            sb.append(s2Array[i]);
            if(i != 0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * Reverses the words in a given string.
     *
     * @TimeComplexity  O(N) - where N is the length of the string s.
     *                         Traversing, trimming, splitting, and rebuilding all take linear time.
     * @SpaceComplexity O(N) - auxiliary space needed for the char[] and StringBuilder
     *                         due to Java's immutable String limitation.
     */
    public String reverseWords_google_l4_follow_up(String s) {
            char[] chars = cleanSpaces(s);
            int n = chars.length;

            reverse(chars, 0, n - 1);

            reverseEachWord(chars, n);

            return new String(chars);
        }

        private char[] cleanSpaces(String s) {
            int left = 0, right = s.length() - 1;
            while (left <= right && s.charAt(left) == ' ') left++;
            while (left <= right && s.charAt(right) == ' ') right--;

            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                char c = s.charAt(left);
                if (c != ' ') {
                    sb.append(c);
                } else if (sb.charAt(sb.length() - 1) != ' ') {
                    // 只保留一个空格
                    sb.append(' ');
                }
                left++;
            }
            return sb.toString().toCharArray();
        }

        private void reverse(char[] chars, int i, int j) {
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }

        private void reverseEachWord(char[] chars, int n) {
            int start = 0, end = 0;
            while (start < n) {
                while (end < n && chars[end] != ' ') end++;
                reverse(chars, start, end - 1);
                start = end + 1;
                end++;
            }
        }
}