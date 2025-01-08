package java;

/**
 * @tag BruteForce
 * @prb https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
 * @author ArtistS
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class Java_3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for(int i = 0; i < words.length;i++){
            for(int j = i+1; j < words.length;j++){
                String str1 = words[i];
                String str2 = words[j];

                if(str1.length() > str2.length()) continue;

                if(str2.startsWith(str1) && str2.endsWith(str1)){
                    res++;
                }
            }
        }
        return res;
    }
}