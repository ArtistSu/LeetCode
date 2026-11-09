package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_50 {
    /**
     * @TimeComplexity O(log(n))
     * @SpaceComplexity O(1)
     */
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            N = -N;
        }

        double res = 1.0;
        double current_product = x;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= current_product;
            }

            current_product *= current_product;
            N >>= 1;
        }

        return n < 0 ? 1.0 / res : res;
    }
}