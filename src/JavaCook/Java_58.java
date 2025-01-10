package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/length-of-last-word/description/
 * Time complexity: O(n), n is the length of s
 * Space complexity:O(1)
 */
public class Java_58 {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0){
            return 0;
        }

        int res = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                res++;
            }else if(res >0){
                break;
            }
        }
        return res;
    }
}