package JavaCook;

/**
 * @author ArtistS
 * @tag Array Math Geometry
 * @prb <a href="https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/editorial/?envType=daily-question&envId=2026-01-17">...</a>
 * @TimeComplexity O(n ^ 2) n is the length of bottomLeft
 * @SpaceComplexity O(1)
 */
public class Java_3047{
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxEdge = 0, xDiff = 0, yDiff = 0, currEdge = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                xDiff = Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                yDiff = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                currEdge = Math.min(xDiff,yDiff);
                maxEdge = Math.max(currEdge,maxEdge);
            }
        }
        return maxEdge * maxEdge;
    }
}