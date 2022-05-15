package JavaCode;

public class Java944 {
    /**
     * Time Complexity: O(mn) {@code m} is the length of strs[0], {@code n} is the length of {@param strs}
     * Space Complexity: O(1)
     * @topic Delete Columns to Make Sorted
     * @author ArtistS
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int ans = 0;

        for(int i = 0; i < strs[0].length(); i++){
            char previous = strs[0].charAt(i);
            for(int j = 1; j < strs.length;j++){
                if(strs[j].charAt(i) < previous){
                    ans += 1;
                    break;
                }
                previous = strs[j].charAt(i);
            }
        }
        return ans;
    }
}
