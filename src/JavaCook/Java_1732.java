package JavaCook;

/**
 * @author ArtistS
 * @tag Array PrefixSum
 * @prb <a href="https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_1732{
    public int largestAltitude(int[] gain) {
        int n  = gain.length, maxAltitude = 0;
        for(int i = 0; i < n; i++){
            if(i != 0){
                gain[i] = gain[i-1] + gain[i];
            }
            maxAltitude = Math.max(gain[i], maxAltitude);
        }
        return maxAltitude;
    }

    public int largestAltitudeV2(int[] gain) {
        int currentAltitude = 0, maxAltitude = currentAltitude;
        for(int altitude: gain){
            currentAltitude += altitude;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
        return maxAltitude;
    }
}