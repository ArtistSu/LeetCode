package JavaCook;


/**
 * @author ArtistS
 * @tag Recursion
 * @prb https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2375_2 {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();

        buildSequence(0, 0, res, pattern.toCharArray());

        return res.reverse().toString();
    }

    // Recursively build the sequence
    public int buildSequence(int currentIndex, int currentCount, StringBuilder res, char[] patternArray) {
        if (currentIndex != patternArray.length) {
            if (patternArray[currentIndex] == 'I') {
                buildSequence(currentIndex+1, currentIndex+1, res, patternArray);
            } else {
                currentCount = buildSequence(currentIndex+1, currentCount, res, patternArray);
            }
        }

        res.append(currentCount + 1);
        return currentCount + 1;
    }


    public static void main(String[] args) {
        new Java_2375_2().smallestNumber("IIIDIDDD");
    }
}