package JavaCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Java242 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param s}
     * Space Complexity: O(1)
     * @topic Valid Anagram
     * @author ArtistS
     * @method Map
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch,0)+1);
        }

        for(int i = 0 ; i < t.length(); i++){
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch,0)-1);
            if(table.get(ch)<0){
                return false;
            }
        }
        return true;
    }
}
