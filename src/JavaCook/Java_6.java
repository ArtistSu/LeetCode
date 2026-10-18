package JavaCook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag String
 * @prb https://leetcode.com/problems/zigzag-conversion/description/ Time complexity: O(n) Space complexity: O(1)
 */
public class Java_6 {
    /**
     * Time complexity: O(N) N is the length of String s
     * Space complexity: O(1)
     */
    public String convert_google_l4(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        int n = s.length();
        char[] characters = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            int currIdx = i;
            if (i == 0 || i == (numRows - 1)) {
                while (currIdx < n) {
                    sb.append(characters[currIdx]);
                    currIdx += cycleLen ;
                }
            } else {
                boolean isEvenStep = true;
                int step1 = 2 * (numRows - i - 1);
                int step2 = 2 * i;

                while (currIdx < n) {
                    sb.append(characters[currIdx]);
                    currIdx += isEvenStep ? step1 : step2;
                    isEvenStep = !isEvenStep;
                }
            }
        }
        return sb.toString();
    }
}