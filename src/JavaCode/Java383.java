package JavaCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Java383 {
    /**
     * Time Complexity: O(n+m) {@param n} is the length of {@param ransomNote}, {@param m} is the length of {@param magazine}
     * Space Complexity: O(1)
     * @topic Ransom Note
     * @author ArtistS
     * @method Array
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(char ch : magazine.toCharArray()){
            arr[ch - 'a'] += 1;
        }
        for(char ch : ransomNote.toCharArray()){
            arr[ch-'a'] -= 1;
            if(arr[ch-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
