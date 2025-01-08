package java;

/**
 * @author ArtistS
 * Time complexity: O(m * n) m is the strs[0] length, n is strs length
 * Space complexity:O(1)
 * @tag
 * @prb https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Java_14 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int prefixLen = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            while(str.length() < prefixLen || !str.substring(0, prefixLen).equals(prefix)) {
                prefixLen--;
                if(prefixLen == 0){
                    return "";
                }
                prefix = prefix.substring(0,prefixLen);
            }
        }
        return prefix;
    }
}