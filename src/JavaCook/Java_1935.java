package JavaCook;

/**
 * @author ArtistS
 * @tag HashTable Array
 * @prb https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/?envType=daily-question
 * Time complexity: O(n * m) n is the length of text, m is the length of brokenLetters
 * Space complexity: O(n * m)
 */
public class Java_1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int brokenWords = 0;
        String[] words = text.split(" ");
        for(String word: words){
            if(exists(word,brokenLetters.toCharArray())){
                brokenWords += 1;
            }
        }
        return words.length - brokenWords;
    }

    public boolean exists(String word, char[] letters){
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < letters.length; j++){
                if(word.charAt(i) == letters[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
