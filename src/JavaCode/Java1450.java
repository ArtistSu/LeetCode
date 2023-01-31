package JavaCode;

public class Java1450 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param endTime}
     * Space Complexity: O(1)
     * @topic Number of Students Doing Homework at a Given Time
     * @author ArtistS
     * @method Traverse
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for(int i = 0; i < endTime.length; i++){
            if(queryTime <= endTime[i]){
                if(queryTime>=startTime[i]){
                    res++;
                }
            }
        }
        return res;
    }
}
