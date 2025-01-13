package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag HashTable
 * @prb https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_3223 {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int del = 0;
        for(int freq : map.values()){
            if(freq % 2 == 1){
                del += freq - 1;
            }else{
                del += freq - 2;
            }
        }
        return s.length() - del;
    }
}