package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_135{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public int candy_google_l4(int[] ratings) {
        // Defensive check
        if(ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;
        int[] candies = new int[n];
        java.util.Arrays.fill(candies, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        int res = candies[n-1];
        for(int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
            res += candies[i];
        }

        return res;
    }
}