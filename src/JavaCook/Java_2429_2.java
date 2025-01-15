package JavaCook;

/**
 * @author ArtistS
 * @tag &|~
 * @prb https://leetcode.com/problems/minimize-xor/description/
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Java_2429_2 {
    public int minimizeXor(int num1, int num2) {
        int result = 0;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = 0;
        int currentBit = 31;

        while (setBitsCount < targetSetBitsCount) {
            if (isSet(num1, currentBit) || (targetSetBitsCount - setBitsCount > currentBit)) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            currentBit--;
        }
        return result;
    }

    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public int setBit(int x, int bit) {
        return (x | (1 << bit));
    }
}