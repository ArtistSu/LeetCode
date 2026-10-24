package JavaCook;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_452{
    /**
     * @TimeComplexity O(N * log(N))
     * @SpaceComplexity O(N)) -> Java Arrays.sort() will use timsort which will take O(N)
     */
    public int findMinArrowShots_google_l4(int[][] points) {
        if(points.length == 1) return 1;

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1, prevEnd = points[0][1];

        for(int i = 1;i < points.length; i++){
            if(points[i][0] > prevEnd){
                res++;
                prevEnd = points[i][1];
            }
        }
        return res;
    }


}