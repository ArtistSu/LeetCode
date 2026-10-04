package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_2300{
    public int[] successfulPairs_google_l4(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];

        for(int i = 0; i < n;i++){
            int left = 0, right = m-1;
            int targetIdx = m;

            long spell = spells[i];
            // Use an overflow-preventing rounding-up method to calculate the minimum required potion strength.
            long minPotionRequired = success / spell + (success % spell == 0 ? 0 : 1);

            while(left <= right){
                int mid = left + (right - left) / 2;
                if(potions[mid] < minPotionRequired){
                    left = mid + 1;
                }else{
                    targetIdx = mid;
                    right = mid - 1;
                }
            }
            res[i] = m - targetIdx;
        }

        return res;
    }
}