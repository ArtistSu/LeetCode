package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Backtracking Counting HashTable String
 * @prb https://leetcode.com/problems/letter-tile-possibilities/description/
 * Time complexity: O(n*n!)
 * Space complexity: O(n*n!)
 */
public class Java_1079{
    public int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        int len = tiles.length();
        boolean[] used = new boolean[len];
        findAllSequence(tiles,new StringBuilder(""),used,res);

        return res.size() - 1;

    }

    public void findAllSequence(String tiles,StringBuilder current,boolean[] used, Set<String> res){
        res.add(current.toString());
        System.out.println(res.toString());

        for(int pos = 0; pos < tiles.length(); pos++){
            if(!used[pos]){
                used[pos] = true;
                findAllSequence(tiles,current.append(tiles.charAt(pos)),used,res);
                current.deleteCharAt(current.length()-1);
                used[pos] = false;
            }
        }
    }

    public static void main(String[] args) {

        new Java_1079().numTilePossibilities("AAB");
    }
}