package JavaCode;

public class Interview17_11 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param words}
     * Space Complexity: O(1)
     * @topic Find Closest LCCI
     * @author ArtistS
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
