package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Carry BruteForce
 * @prb https://leetcode.com/problems/add-binary/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_67 {
    /**
     * Time complexity: O(Max(N,M) N is the length of String a, M is the length of String b
     * Space complexity: O(Max(N,M)
     */
    public String addBinary(String a, String b) {
        int startA = a.length() - 1;
        int startB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while(startA >= 0 || startB >= 0 || carry == 1){
            if(startA >= 0){
                carry += a.charAt(startA) - '0';
            }

            if(startB >= 0){
                carry += b.charAt(startB) - '0';
            }

            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }
}