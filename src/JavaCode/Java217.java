package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java217 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param nums}
     * Space Complexity: o(n)
     * @topic Contains Duplicate
     * @author ArtistS
     * @method HashSet
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                return true;
            }
        }
        return false;
    }
}
