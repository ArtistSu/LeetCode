package JavaCook;

/**
 * @author ArtistS
 * @tag CharArray
 * @prb https://leetcode.com/problems/construct-k-palindrome-strings/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_1400 {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }

        char[] chars = s.toCharArray();
        int[] res = new int[26];
        for(int i = 0; i < chars.length;i++){
            char ch = chars[i];
            res[ch-'a']++;
        }

        int singular = 0;
        for(int count: res){
            if(count%2 == 1){
                singular++;
            }
        }

        return singular <= k;
    }
}