package Easy;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/27 7:59 下午
 * Description:
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> frequencyElement = new HashMap<>();
        for (int currElement :
                nums) {
            if (frequencyElement.containsKey(currElement)) {
                int value = frequencyElement.get(currElement) + 1;
                frequencyElement.put(currElement, value);
                if (value > nums.length / 2) {
                    return currElement;
                }
                continue;
            }
            frequencyElement.put(currElement, 1);
        }
        return 0;
    }

    //2.本题默认一定会有众数, 也就是n/2一定是众数, 所以一个排序后n/2一定是众数
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //3.Boyer-Moore
    public int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num :
                nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
