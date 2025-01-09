package JavaCook;

/**
 * @author ArtistS
 * @tag prefix
 * @prb https://leetcode.com/problems/counting-words-with-a-given-prefix/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2185 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word: words){
            if(word.startsWith(pref)){
                res++;
            }
        }
        return res;
    }
}