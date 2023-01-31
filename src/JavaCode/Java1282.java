package JavaCode;

import java.util.*;

public class Java1282 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param groupSizes}
     * Space Complexity: O(n)
     * @topic Group the People Given the Group Size They Belong To
     * @author ArtistS
     * @method stimulation
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        int len = groupSizes.length;

        for(int i = 0; i < len; i++){
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<Integer>());
            map.get(size).add(i);
            if(map.get(size).size() == size){
                res.add(map.get(size));
                map.put(size, new ArrayList<Integer>());
            }
        }
        return res;
    }
}
