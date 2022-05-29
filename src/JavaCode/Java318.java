package JavaCode;

public class Java318 {
    /**
     * Time Complexity: O(n^2) {@code n} is the length of {@param words}
     * Space Complexity: O(n)
     * @method bit operation
     * @topic Maximum Product of Word Lengths
     * @author ArtistS
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int len = words.length, res = 0;
        int[] mask = new int[len];
        for(int i = 0; i < len; i++){
            String currWord = words[i];
            for(int j = 0; j < currWord.length(); j++){
                mask[i] |= 1 << (currWord.charAt(j)-'a');
            }
        }

        for(int i = 0; i < len; i++){
            int wordA = mask[i];
            for(int j = 0; j < len; j++){
                int wordB = mask[j];
                if((wordA & wordB) == 0){
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}
