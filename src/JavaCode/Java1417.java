package JavaCode;

import java.util.LinkedList;
import java.util.List;

public class Java1417 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @topic Reformat The String
     * @author ArtistS
     * @method Split + Splice
     * @param s
     * @return
     */
    public String reformat(String s) {
        List<Character> digits = new LinkedList<>();
        List<Character> letters = new LinkedList<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                digits.add(ch);
            }else{
                letters.add(ch);
            }
        }

        if(Math.abs(digits.size()-letters.size())>1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Math.min(digits.size(), letters.size()); i++){
            sb.append(digits.get(i));
            sb.append(letters.get(i));
        }
        if(digits.size() < letters.size()){
            sb.insert(0,letters.get(letters.size() - 1));
        }
        if(digits.size() > letters.size()){
            sb.append(digits.get(digits.size() - 1));
        }
        return sb.toString();
    }
}
