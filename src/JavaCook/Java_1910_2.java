package JavaCook;

/**
 * @author ArtistS
 * @tag String Stack Simulation
 * @prb https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class Java_1910_2 {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int partStartIndex = s.indexOf(part);

            s =
                    s.substring(0, partStartIndex) +
                            s.substring(partStartIndex + part.length());
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Java_1910_2().removeOccurrences("daabcbaabcbc", "abc"));
    }
}