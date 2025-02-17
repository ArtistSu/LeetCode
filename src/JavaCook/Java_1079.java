package JavaCook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ArtistS
 * @tag
 * @prb
 * Time complexity:
 * Space complexity:
 */
public class Java_1079{
    public int numTilePossibilities(String tiles) {
        int len = tiles.length();
        int distinctNum = 0;
        int[] dic = new int[26];
        int res = 0;
        Map<Character, List<Character>> map = new HashMap<>();


        // To get all distinct letter in tiles
        for(char tile : tiles.toCharArray()){
            if(dic[tile-'A'] == 0){
                distinctNum++;
            }
            dic[tile-'A']++;
            if(map.containsKey(tile)){
                map.get(tile).add(tile);
            }else{
                map.put(tile, new ArrayList<Character>());
                map.get(tile).add(tile);
            }
        }


        List<Integer> suffix = new ArrayList<>();
        suffix.add(distinctNum);
        res+=distinctNum;

        for(int number = 1; number < len && distinctNum != 0; number++){
                // If pickup number > distinct letter num
                distinctNum = 0;
                for (List<Character> list : map.values()) {
                    if(list.size() > number){
                        distinctNum++;
                    }
                }
                int tempSuffix = suffix.get(number-1) * distinctNum;
                res += tempSuffix;
            }
        return suffix.get(suffix.size()-1);
    }

    public int nAn(int number, int totalCharacters){
        int res_n = 1;
        for(int i = totalCharacters; i >= totalCharacters-number+1; i--){
            res_n *= i;
        }

        return  res_n;
    }

    public static void main(String[] args) {

        new Java_1079().numTilePossibilities("AAB");
    }
}