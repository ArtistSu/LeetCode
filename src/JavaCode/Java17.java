package JavaCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Java17 {
    /**
     * Time Complexity: O(3^m * 4^n) {@code m} is the number of digit whose string length is 3, {@code n} is the number of digit whose string length is 4
     * Space Complexity: O(m + n)
     * @method recursion
     * @topic Letter Combinations of a Phone Number
     * @author ArtistS
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new LinkedList<>();
        if (digits.length() <= 0) {
            return combinations;
        }
        Map<Character, String> digitAndLetter = new HashMap<>();
        digitAndLetter.put('2', "abc");
        digitAndLetter.put('3', "def");
        digitAndLetter.put('4', "ghi");
        digitAndLetter.put('5', "jkl");
        digitAndLetter.put('6', "mno");
        digitAndLetter.put('7', "pqrs");
        digitAndLetter.put('8', "tuv");
        digitAndLetter.put('9', "wxyz");

        backtrack(combinations, digitAndLetter, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
