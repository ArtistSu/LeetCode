package JavaCode;

import java.util.TreeMap;

public class Java732 {
    private TreeMap<Integer, Integer> map;

    public Java732() {
        map = new TreeMap<Integer, Integer>();
    }

    /**
     * Time Complexity: O(2n) {@code n} is the number of events each event has two key points
     * Space Complexity: O(2n)
     * @method difference
     * @topic My Calendar III
     * @author ArtistS
     * @param start
     * @param end
     * @return
     */
    public int book(int start, int end) {
        int maxBook = 0;
        int temp= 0;
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        for(int key: map.keySet()){
            int curr = map.get(key);
            temp = curr+temp;
            maxBook = Math.max(maxBook, temp);
        }
        return maxBook;
    }
}
