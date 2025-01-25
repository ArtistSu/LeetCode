package JavaCook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Array UnionFind Sorting
 * @prb https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/
 * Time complexity: O(logn)
 * Space complexity: O(n)
 */
public class Java_2948{
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);

        int currGroup = 0;
        Map<Integer,Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(currGroup, new LinkedList<Integer>(Arrays.asList(numsSorted[0])));

        for (int i = 1; i < nums.length; i++){
            if(Math.abs(numsSorted[i] - numsSorted[i-1]) > limit){
                currGroup++;
            }

            numToGroup.put(numsSorted[i],currGroup);

            if(!groupToList.containsKey(currGroup)){
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
    }
}