package Easy;

import java.util.*;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/12 11:18 上午
 * Description:
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                result.put(nums[i], result.get(nums[i]) + 1);
                continue;
            }
            result.put(nums[i], 1);

        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();
        for (int i :
                nums) {
            if (!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(new Integer(i));
            }
        }
        return no_duplicate_list.get(0);
    }

    public int singleNumber3(int[] nums) {
        Map<Integer, Integer> hash_table = new HashMap<>();
        for (int i :
                nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i :
                nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    public int singleNumber4(int[] nums) {
        int sumOfSet = 0;
        int sumOfNums = 0;
        Set<Integer> set = new HashSet<>();
        for (int i :
                nums) {
            if (!set.contains(i)) {
                set.add(i);
                sumOfSet += i;
            }
            sumOfNums += i;
        }
        return 2 * sumOfSet - sumOfNums;
    }

    public int singleNumber5(int[] nums) {
        int currentNum = 0;
        for (int i :
                nums) {
            currentNum = currentNum ^ i;
        }
        return currentNum;
    }
}
