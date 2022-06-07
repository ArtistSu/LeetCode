package JavaCode;

public class Java1037 {
    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @topic: Valid Boomerang
     * @author: ArtistS
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
        int[] a = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] b = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return a[0] * b[1] - a[1] * b[0] != 0;
    }
}
