package JavaCode;

public class Java344 {
    /**
     * Two pointers techniques
     * Time Complexity : O(n / 2) {@param n} is the length of {@param s}
     * Space Complexity : O(1)
     * @topic Reverse String
     * @author ArtistS
     * @method Two pointers
     * @param s
     */
    public void reverseString2(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right){
            swap(s, left++, right--);
        }
    }

    public void swap(char[] s, int idxA, int idxB){
        char temp = s[idxA];
        s[idxA] = s[idxB];
        s[idxB] = temp;
    }
    /**
     * Two pointers techniques
     * Time Complexity : O(n / 2)
     * Space Complexity : O(1)
     * @param s
     */
    public void reverseString(char[] s) {
        // traversal the array s, the times is s.length / 2
        for (int i = 0; i < (s.length / 2); i++) {
            char tempCh = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tempCh;
        }
    }

}
