package JavaCode;

public class Java50 {
    /**
     * Time Complexity: O(log n) {@param n}
     * Space Complexity: O(log n)
     * @method divide and concur
     * @topic Pow(x, n)
     * @author ArtistS
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return n >=0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double y = quickMul(x, n/2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
