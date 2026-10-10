package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_1318{
    /**
     * @TimeComplexity O(log(Max(a,b,c)))
     * @SpaceComplexity O(1)
     */
    public int minFlips_google_l4(int a, int b, int c) {
        int res = 0, bitA = 0,bitB = 0,bitC = 0;
        while( a > 0 || b > 0 || c > 0){
            bitA = a & 1;
            bitB = b & 1;
            bitC = c & 1;

            if(bitC == 1){
                if((bitA | bitB) == 0){
                    res++;
                }
            }else{
                res += (bitA + bitB);
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return res;
    }
}