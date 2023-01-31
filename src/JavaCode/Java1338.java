package JavaCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Java1338 {
    /**
     * Time Complexity: O(nlogn) {@param n} is the length of {@param arr}
     * Space Complexity: O(n)
     * @topic Reduce Array Size to The Half
     * @author ArtistS
     * @method Greedy & Hash
     * @param arr
     * @return
     */
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            pairs.merge(arr[i],1, Integer::sum);
        }

        Integer[] integers = pairs.values().toArray(new Integer[0]);
        Arrays.sort(integers);
        int count = 0;
        for(int i = integers.length-1; i >= 0;i--){
            count += integers[i];
            if(count >= (arr.length / 2)){
                return integers.length - i;
            }
        }
        return -1;
    }
}
