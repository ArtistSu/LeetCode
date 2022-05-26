package JavaCode;

public class Java191 {
    /**
     * Time Complexity: O(m) {@code m} is the number of bits of {@param n}
     * Space Complexity: O(1)
     * @param n
     * @return
     * @topic Number of 1 Bits
     * @author ArtistS
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

}
