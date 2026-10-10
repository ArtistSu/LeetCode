package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_338{
    /**
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            ans[i] = findOne(i);
        }
        return ans;
    }

    private int findOne(int digit){
        int res = 0;
        while(digit > 0){
            if(digit % 2 != 0){
                res++;
            }
            digit = digit >> 1;
        }
        return res;
    }

    /**
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public int[] countBits_google_l4(int n) {
        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }


}