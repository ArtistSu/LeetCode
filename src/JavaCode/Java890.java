package JavaCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java890 {
    /**
     * Time Complexity: O(nm) {@code n} is the length of {@param words}, {@code m} is the length of each word in {@param words}
     * Space Complexity: O(m)
     * @method Double Map
     * @topic Find and Replace Pattern
     * @author ArtistS
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(match(words[i], pattern) && match(pattern, words[i])){
                res.add(words[i]);
            }
        }
        return res;
    }

    public boolean match(String a, String b){
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char x = a.charAt(i), y = b.charAt(i);
            if(!map.containsKey(x)){
                map.put(x,y);
            }else if(map.get(x) != y){
                return false;
            }
        }
        return true;
    }
}
