package JavaCode;

public class Java953 {
    /**
     * Time Complexity: O(n) {@code n} is the sum of the length of each word
     * Space Complexity: O(1)
     * @topic Verifying an Alien Dictionary
     * @author ArtistS
     * @param words
     * @param order
     * @return
     */
    int alphabet[] = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            alphabet[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isBefore(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isBefore(String s1, String s2) {

        if (s1.length() <= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
                if (alphabet[a] > alphabet[b]) {
                    return false;
                } else if (alphabet[a] < alphabet[b]) {
                    return true;
                }
            }
            return true;
        }
        return !isBefore(s2, s1);
    }
}
