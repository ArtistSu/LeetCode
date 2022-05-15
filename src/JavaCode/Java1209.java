package JavaCode;

import java.util.LinkedList;

public class Java1209 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @topic Remove All Adjacent Duplicates in String II
     * @author ArtistS
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}

