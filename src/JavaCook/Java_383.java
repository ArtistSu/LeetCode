package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_383{
    /**
     * @TimeComplexity O(N+M) N is the length of ransomNote, M is the length of magazine
     * @SpaceComplexity O(1)
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for(char ch : magazine.toCharArray()){
            letters[ch-'a'] += 1;
        }

        for(char ch : ransomNote.toCharArray()){
            if(letters[ch-'a'] >= 1){
                letters[ch-'a'] -= 1;
            }else{
                return false;
            }
        }
        return true;
    }
}