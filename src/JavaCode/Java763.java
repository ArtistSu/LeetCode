package JavaCode;



import java.util.*;

public class Java763 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param s}
     * Space Complexity: O(n)
     * @topic
     * @author ArtistS
     * @method Greedy
     * @param s
     * @return
     */
    public List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    /**
     * Time Complexity: O(n) {@param n} is the length of {@param s}
     * Space Complexity: O(n)
     * @topic
     * @author ArtistS
     * @method Greedy
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        // Find the last index
        for(int i = 0; i < s.length(); i++){
            char currCh = s.charAt(i);
            map.put(currCh, Math.max(map.getOrDefault(currCh,i),i));
        }

        int start = 0;
        int maxPosition = map.get(s.charAt(0));
        for(int i = 0; i < s.length(); i++){
            char currCh = s.charAt(i);
            maxPosition = Math.max(maxPosition, map.get(currCh));
            if(i == maxPosition){
                res.add(maxPosition-start+1);
                start = maxPosition+1;
            }
        }
        return res;
    }
}
