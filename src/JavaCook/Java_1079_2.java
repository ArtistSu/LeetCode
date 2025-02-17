package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Backtracking Counting HashTable String
 * @prb https://leetcode.com/problems/letter-tile-possibilities/description/
 * Time complexity: O(n!)
 * Space complexity: O(n)
 */
public class Java_1079_2 {
    public int numTilePossibilities(String tiles) {
        int[] charCount = new int[26];
        for(char ch : tiles.toCharArray()){
            charCount[ch-'A']++;
        }
        return findAllSequence(charCount);
    }

    public int findAllSequence(int[] charCount){
        int res = 0;
        for(int i=0; i<charCount.length; i++){
            if(charCount[i] == 0) continue;
            res++;
            charCount[i]--;
            res += findAllSequence(charCount);
            charCount[i]++;
        }
        return res;
    }

    public static void main(String[] args) {

        new Java_1079_2().numTilePossibilities("AAB");
    }
}