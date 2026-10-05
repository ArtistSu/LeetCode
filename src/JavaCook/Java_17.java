package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_17{
    // Name convention
    private static final String[] LETTER_MAP = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations_google_l4(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0 ) return res;

        dfs(0,digits,res,new StringBuilder());

        return res;
    }


    public void dfs(int index, String digits,List<String> res, StringBuilder path){
        if(index == digits.length()){
            res.add(path.toString());
            return ;
        }

        int digit = digits.charAt(index) - '0';

        // Defensive check
        if(digit < 2 || digit > 9) return ;

        String letters = LETTER_MAP[digit];

        for(int i = 0; i < letters.length(); i++){
            path.append(letters.charAt(i));
            dfs(index+1,digits,res,path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}