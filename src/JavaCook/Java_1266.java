package JavaCook;

/**
 * @author ArtistS
 * @tag Array Math Geometry
 * @prb <a href="https://leetcode.com/problems/minimum-time-visiting-all-points/?envType=daily-question&envId=2026-01-12">...</a>
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_1266{
    public int minTimeToVisitAllPoints(int[][] points) {
        // Edge case
        if(points.length == 1) return 0;

        int index1 = 0, index2 = 1, n = points.length, minStep = 0;
        while(index2 < n){
            minStep += minSteps(points, index1++, index2++);
        }
        return minStep;
    }

    public int minSteps(int[][] points, int index1, int index2){
        int diff1 = Math.abs(points[index1][0] - points[index2][0]);
        int diff2 = Math.abs(points[index1][1] - points[index2][1]);

        return diff1 > diff2 ? diff1 : diff2;
    }
}