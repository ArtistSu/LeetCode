package JavaCook;

/**
 * @author ArtistS
 * @tag String SlidingWindow LC75
 * @prb <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_1456{
    public int maxVowels(String s, int k) {
        int maxVowel = 0;
        String vowels = "aeiou";
        int count = 0;
        for(int i =0 ; i < k; i++){
            if(vowels.indexOf(s.charAt(i)) != -1) count++;
        }
        maxVowel = Math.max(maxVowel,count);

        for(int i = k; i < s.length(); i ++){
            if(vowels.indexOf(s.charAt(i-k)) != -1) count--;
            if(vowels.indexOf(s.charAt(i)) != -1) count++;
            maxVowel = Math.max(maxVowel,count);
        }
        return maxVowel;
    }

    public int maxVowelsV2(String s, int k) {
        int maxVowel = 0, count = 0;
        for(int i =0 ; i < k; i++){
            if(isVowel(s.charAt(i))) count++;
        }
        maxVowel = Math.max(maxVowel,count);

        for(int i = k; i < s.length(); i ++){
            if(isVowel(s.charAt(i-k))) count--;
            if(isVowel(s.charAt(i))) count++;
            maxVowel = Math.max(maxVowel,count);
        }
        return maxVowel;
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}