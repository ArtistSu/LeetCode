package JavaCook;

/**
 * @author ArtistS
 * @tag &|~
 * @prb https://leetcode.com/problems/minimize-xor/description/
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Java_2429 {
    public int minimizeXor(int num1, int num2) {
        int result = num1;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);

        int currBit = 0;
        while (setBitsCount < targetSetBitsCount) {
            if (!isSet(result, currBit)) {
                result = setBit(result, currBit);
                setBitsCount++;
            }
            currBit++;
        }

        while (setBitsCount > targetSetBitsCount) {
            if (isSet(result, currBit)) {
                result = unsetBit(result, currBit);
                setBitsCount--;
            }
            currBit++;
        }
        return result;
    }

    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public int setBit(int x, int bit) {
        return (x | (1 << bit));
    }

    public int unsetBit(int x, int bit) {
        return (x & ~(1 << bit));
    }
}