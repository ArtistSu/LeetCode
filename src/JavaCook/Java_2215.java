package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Array HashTable
 * @prb <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/editorial/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(N + M) N is the length of nums1, M is the length of nums2
 * @SpaceComplexity: O(N + M)
 */
public class Java_2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : nums1) set1.add(num);
        for(int num: nums2) set2.add(num);

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for(int num : set1){
            if (!set2.contains(num)){
                res1.add(num);
            }
        }

        for(int num : set2){
            if (!set1.contains(num)){
                res2.add(num);
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        res.add(res1);
        res.add(res2);

        return res;
    }
}