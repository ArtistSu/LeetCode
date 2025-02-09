package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag HashTable Math
 * @prb https://leetcode.com/problems/assign-elements-to-groups-with-constraints/description/
 * Time complexity: O(n√n)
 * Space complexity: O(1)
 */
public class Java_3447 {
    public int[] assignElements(int[] groups, int[] elements) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            elementIndexMap.putIfAbsent(elements[i], i);
        }

        int[] res = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            res[i] = findSmallestIndex(groups[i], elementIndexMap);
        }
        return res;
    }

    public int findSmallestIndex(int groupSize, Map<Integer, Integer> elementIndexMap) {
        int minIndex = Integer.MAX_VALUE;
        // The smallest divisor of a number must be less than the square root of the number
        for (int i = 1; i * i <= groupSize; i++) {
            if (groupSize % i == 0) {
                if (elementIndexMap.containsKey(i)) {
                    minIndex = Math.min(minIndex, elementIndexMap.get(i));
                }
                if (i != groupSize / i && elementIndexMap.containsKey(groupSize / i)) {
                    minIndex = Math.min(minIndex, elementIndexMap.get(groupSize / i));
                }
            }
        }
        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }
}