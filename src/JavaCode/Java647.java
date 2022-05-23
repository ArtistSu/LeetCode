package JavaCode;

public class Java647 {


    /**
     * Time Complexity: O(n^2) {@code n} is the length of {@param s}
     * Space Complexity: O(1)
     * @topic Palindromic Substrings
     * @author ArtistS
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length(), res = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= 1; j++){
                int left = i, right = i + j;
                while(i>=0 && right <= len-1 && s.charAt(left) == s.charAt(right)){
                    res++;
                }
            }
        }
        return res;

    }


}
