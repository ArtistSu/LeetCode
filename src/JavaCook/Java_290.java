package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_290{
    /**
     * @TimeComplexity O(N) N is the length of pattern
     * @SpaceComplexity O(M) M is the number of unique letters in pattern
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        if(chars.length != words.length) return false;

        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            char ch = chars[i];
            String w = words[i];

            if(c2s.containsKey(ch)){
                if(!c2s.get(ch).equals(w)){
                    return false;
                }
            }else{
                if(s2c.containsKey(w)){
                    return false;
                }
                c2s.put(ch,w);
                s2c.put(w,ch);
            }
        }
        return true;
    }
}