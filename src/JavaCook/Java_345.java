package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag TwoPointer String
 * @prb https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(vowels.contains(ch)) sb.append(ch);
        }

        int idx = sb.length()-1;
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(vowels.contains(ch)){
                res.append(sb.charAt(idx--));
            }else{
                res.append(ch);
            }
        }

        return res.toString();
    }

    public String reverseVowelsV2(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int start = 0, end = s.length()-1;
        char[] chs = s.toCharArray();
        while(start < end){
            if(!vowels.contains(chs[start])){
                start++;
            }
            if(!vowels.contains(chs[end])){
                end--;
            }
            if(vowels.contains(chs[start]) && vowels.contains(chs[end])){
                char temp = chs[start];
                chs[start] = chs[end];
                chs[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chs);
    }

    public String reverseVowelsV3(String s) {
        String vowels = "aeiouAEIOU";

        int start = 0, end = s.length()-1;
        char[] chs = s.toCharArray();
        while(start < end){
            if(vowels.indexOf(chs[start]) == -1){
                start++;
            }
            if(vowels.indexOf(chs[end]) == -1){
                end--;
            }
            if(vowels.indexOf(chs[start]) != -1 && vowels.indexOf(chs[end]) != -1){
                char temp = chs[start];
                chs[start] = chs[end];
                chs[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chs);
    }
}
