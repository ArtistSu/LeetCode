package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_30{
    /**
     * @TimeComplexity O(N * wordLen) N is the length of String s, wordLen is the length of each word in array words
     * @SpaceComplexity O(M * wordLen) M is the length of array words
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if(words == null || words.length == 0 || s == null || s.length() == 0) return new ArrayList<>();

        int n = s.length();
        int wordLen = words[0].length();

        // Word frequency
        Map<String,Integer> dic = new HashMap<>();
        for(String word: words){
            dic.put(word,dic.getOrDefault(word,0)+1);
        }

        List<Integer> res = new ArrayList<>();
        // i is the start
        for(int i = 0; i < wordLen; i++){
            Map<String,Integer> hasFound = new HashMap<>();
            int left = i, right = i, count = 0;

            while(right + wordLen <= n){
                String curr = s.substring(right,right+wordLen);
                right += wordLen;

                if(dic.containsKey(curr)){
                    hasFound.put(curr,hasFound.getOrDefault(curr,0)+1);
                    count++;

                    while(hasFound.get(curr) > dic.get(curr)){
                        String leftWord = s.substring(left,left+wordLen);
                        hasFound.put(leftWord,hasFound.get(leftWord)-1);
                        left+=wordLen;
                        count--;
                    }

                    if(count == words.length){
                        res.add(left);
                        String leftWord = s.substring(left,left+wordLen);
                        hasFound.put(leftWord,hasFound.get(leftWord)-1);
                        left+=wordLen;
                        count--;
                    }
                }else{
                    hasFound.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}