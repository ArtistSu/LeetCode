package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Array HashTable String Backtracking
 * @prb https://leetcode.com/problems/find-unique-binary-string/description/
 * Time complexity:O(2^n)
 * Space complexity: O(n)
 */
public class Java_1980 {
    Set<String> dic = new HashSet<>();

    public String findDifferentBinaryString(String[] nums) {
        String[] res = new String[1];

        for (String num : nums) {
            dic.add(num);
        }

        generateBinaryStrings(0, nums.length, new StringBuilder(),res);

        return res[0];

    }

    public void generateBinaryStrings(int count, int len, StringBuilder sb, String[] res) {
        if (count == len) {
            if (!dic.contains(sb.toString())) {
                res[0] = sb.toString();
            }
            return;
        }

        for (int i = 0; i <= 1; i++) {
            sb.append(i);
            generateBinaryStrings(count + 1, len, sb, res);
            if (res[0] != null) return;
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        new Java_1980().findDifferentBinaryString(new String[]{"111","011","001"});
    }
}