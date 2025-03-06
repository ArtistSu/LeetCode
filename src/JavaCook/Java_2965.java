package JavaCook;

/**
 * @author ArtistS
 * @tag Array HashTable Math Matrix
 * @prb https://leetcode.com/problems/find-missing-and-repeated-values/
 * Time complexity: O(n)
 * Space complexity: O(n) n is the square of the length of grid
 */
public class Java_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int[] dic = new int[grid.length * grid.length + 1];

        for (int i = 0; i < grid.length; i++) {
            int[] tempArr = grid[i];
            for (int num : tempArr) {
                if (dic[num] == 1) {
                    res[0] = num;
                } else {
                    dic[num] = 1;
                }
            }
        }

        for (int index = 1; index < dic.length; index++) {
            if (dic[index] == 0) {
                res[1] = index;
                break;
            }
        }
        return res;
    }
}