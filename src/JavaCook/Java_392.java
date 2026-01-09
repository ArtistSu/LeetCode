package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers
 * @prb https://leetcode.com/problems/is-subsequence/description/
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(1)
 */
public class Java_392 {
    public boolean isSubsequence(String s, String t) {
        int pointer = 0;

        if(s.length() == 0) return true;
        if(s.length() > t.length()) return  false;

        for(int i = 0; i < t.length(); i++){
            if(pointer < s.length() && s.charAt(pointer) == t.charAt(i)){
                pointer++;
            }
            if(pointer == s.length()) return true;
        }
        return false;
    }

    public boolean isSubsequenceV2(String s, String t) {
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx1++;
            }
            idx2++;
        }
        return idx1 == s.length();
    }
}