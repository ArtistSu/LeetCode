package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_134{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int canCompleteCircuit_google_l4(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length != cost.length) return -1;

        int totalTank = 0, currTank = 0, startStation = 0, n = gas.length;

        for(int i = 0; i < n; i++){
            int nextGain = gas[i] - cost[i];
            totalTank += nextGain;
            currTank += nextGain;

            if(currTank < 0){
                startStation = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startStation : -1;
    }
}