package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/add-digits/description/
 * Time complexity: O(logn * logn)
 * Space complexity: O(1)
 */
public class Java_258_2 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        while (num > 9) {
            num = sumNum(num);
        }
        return num;
    }

    public int sumNum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}