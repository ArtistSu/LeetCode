package JavaCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Java820 {
    /**
     * Time Complexity: O(n*m) {@code n} is the length of {@param words}, {@code m} is the length of words[i]
     * Space Complexity: O(n)
     * @topic
     * @Author ArtistS
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        for (String word: words) {
            for (int i = 1; i< word.length();i++) {
                good.remove(word.substring(i));
            }
        }

        int res = 0;
        for (String word: good) {
            res += word.length() + 1;
        }
        return res;
    }
}
