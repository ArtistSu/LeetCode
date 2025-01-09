package JavaCook;

/**
 * @author ArtistS
 * @tag CharacterComparison
 * @prb https://leetcode.com/problems/palindrome-number/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        String str = String.valueOf(x);
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}