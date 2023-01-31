package JavaCode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java349 {
    /**
     * Time Complexity: O(n) {@param n} is the max length of {@param nums1} {@param nums2}
     * Space Complexity: O(n)
     * @topic Intersection of Two Arrays
     * @author ArtistS
     * @method Stream
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    /**
     * Time Complexity: O(n) {@param n} is the max length of {@param nums1} {@param nums2}
     * Space Complexity: O(n)
     * @topic Intersection of Two Arrays
     * @author ArtistS
     * @method Collection
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        list.retainAll(set2);
        set1.addAll(list);
        return set1.stream().mapToInt(i->i).toArray();
    }

}
