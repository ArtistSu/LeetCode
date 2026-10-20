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
public class Java_76{
    /**
     * @TimeComplexity O(M) M is the length of String s
     * @SpaceComplexity O(N) N is the length of String t
     * @Tips dic.get() will return Integer object rather than int value, so you must use .intValue() or you need to use
     * .equals() to compare 2 objects
     */
    public String minWindow_google_l4(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";

        int m= s.length();
        int n = t.length();
        Map<Character,Integer> dic = new HashMap<>();

        // Character frequency
        for(char ch : t.toCharArray()){
            dic.put(ch,dic.getOrDefault(ch,0)+1);
        }

        int left = 0, right = 0, requiredTypeCount = dic.size(),formedTypeCount = 0;
        int minLen = Integer.MAX_VALUE, startIdx = 0;
        Map<Character,Integer> hasFound = new HashMap<>();

        while(right < m){
            char curr = s.charAt(right);
            if(dic.containsKey(curr)){
                hasFound.put(curr,hasFound.getOrDefault(curr,0)+1);

                if(dic.get(curr).intValue() == hasFound.get(curr).intValue()){
                    formedTypeCount++;
                }
            }

            while(formedTypeCount == requiredTypeCount){
                if(right - left +1 < minLen){
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                if(hasFound.containsKey(leftChar)){
                    if(hasFound.getOrDefault(leftChar,0).intValue() == dic.get(leftChar).intValue()){
                        formedTypeCount--;
                    }

                    int times = hasFound.get(leftChar);
                    if(times == 1){
                        hasFound.remove(leftChar);
                    }else{
                        hasFound.put(leftChar,times-1);
                    }
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx,startIdx+minLen);
    }
}