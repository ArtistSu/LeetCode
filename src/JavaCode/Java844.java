package JavaCode;

public class Java844 {
    /**
     * Time Complexity: O(S + T) S is the length of the string @s  T is the length of the String @t
     * Space Complexity: O(S+T)
     * @topic Backspace String Compare
     * @author ArtistS
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        String strS = back(charS);
        String strT = back(charT);
        if (strS.equals(strT)) {
            return true;
        } else {
            return false;
        }
    }

    public String back(char[] chars) {
        int ptr = 0, endPtr = chars.length;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#' && i - 1 > 0) {
                ptr = i - 1;
                endPtr--;
            } else {
                chars[ptr] = chars[i];
            }
        }
        return chars.toString().substring(ptr, endPtr);
    }
}
