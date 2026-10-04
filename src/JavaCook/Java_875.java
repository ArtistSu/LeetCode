package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_875{
    public int minEatingSpeed_google_l4(int[] piles, int h) {
        if(piles == null ) return -1;

        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(right,pile);
        }

        while(left < right){
            int mid = left + (right - left) / 2;

            if(canFinish(piles,mid, h)){
                right = mid;
            }else{
                left = mid + 1;
            }

        }
        return left;
    }

    private boolean canFinish(int[] piles, int k, int h){
        if(piles == null ) return false;

        long hours = 0;
        for(int pile : piles){
            // hours += (pile + k -1)/k
            hours += pile / k + (pile % k == 0? 0 : 1);
        }
        return hours <= h;
    }
}