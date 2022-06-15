package JavaCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Java1048 {
    /**
     * Time Complexity: O(nlogn) + O(n * m) {@code n} is the length of {@param words}, {@code m} is the length of each word in {@param words}
     * Space Complexity: O(n)
     * @method DP
     * @topic Longest String Chain
     * @author ArtistS
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str0, String str1) {
                return str0.length() - str1.length();
            }
        });

        Map<String, Integer> map = new HashMap<>();
        int res = 1;

        for (String word : words) {
            int cnt = 1;
            int len = word.length();
            for (int j = 0; j < len; j++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(j);
                String ele = sb.toString();
                if (map.containsKey(ele)) {
                    cnt = Math.max(cnt, map.get(ele) + 1);
                }
            }
            map.put(word, cnt);
            res = Math.max(res, cnt);
        }
        return res;
    }
}
