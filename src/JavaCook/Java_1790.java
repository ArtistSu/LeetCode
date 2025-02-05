package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag HashTable String Counting
 * @prb https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_1790{
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        List<Integer> index = new LinkedList<>();

        for( int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                index.add(i);
            }
        }

        if(index.size() > 2 || index.size() == 1){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        return s1.charAt(index.get(0)) == s2.charAt(index.get(1)) && s1.charAt(index.get(1)) == s2.charAt(index.get(0));
    }
}