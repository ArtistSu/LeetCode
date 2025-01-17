package JavaCook;

/**
 * @author ArtistS
 * @tag Xor
 * @prb https://leetcode.com/problems/neighboring-bitwise-xor/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2683{
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int num : derived){
            xor ^= num;
        }
        return xor == 0;
    }
}