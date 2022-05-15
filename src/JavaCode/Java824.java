package JavaCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Java824 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @topic Goat Latin
     * @author ArtistS
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        int len = strs.length;
        String s = "a,e,i,o,u,A,E,I,O,U";
        Set<String> vowel = new HashSet<>(Arrays.asList(s.split(",")));

        for(int i = 0; i<len; i++){
            StringBuffer res = new StringBuffer(strs[i]);
            char ch = strs[i].charAt(0);
            if(!(vowel.contains(String.valueOf(ch)))){
                res.deleteCharAt(0);
                res.append(ch);
            }
            res.append("ma");
            for(int times = 0; times < i+1;times++){
                res.append("a");
            }
            strs[i] = res.toString();
        }
        return String.join(" ", strs);
    }

    public static void main(String[] args) {
        String s = "over the lazy dog";
        System.out.println(new Java824().toGoatLatin(s));

        String s2 = "a,e,i,o,u,A,E,I,O,U";
        Set<String> vowel = new HashSet<>(Arrays.asList(s2.split(",")));
        System.out.println(vowel.contains("o"));
    }
}
