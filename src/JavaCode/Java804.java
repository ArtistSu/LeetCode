package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java804 {
    /**
     * Time Complexity: O(n) {@param n} is the total length of word in {@param words}
     * Space Complexity: O(n)
     * @topic Unique Morse Code Words
     * @author ArtistS
     * @method Hash
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] strs = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();
        for(String word: words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                sb.append(strs[ch-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
