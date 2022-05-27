package JavaCode;

public class Java1342 {
    /**
     * Time Complexity: O(log num) {@param num}
     * Space Complexity: O(1)
     * @Topic Number of Steps to Reduce a Number to Zero
     * @author ArtistS
     * @param num
     * @return
     */
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
                res++;
            }
            if (num % 2 != 0) {
                num = num - 1;
                res++;
            }
        }
        return res;
    }
}
