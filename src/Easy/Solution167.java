package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/25 3:01 下午
 * Description:
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return null;
        }
        int arrLength = numbers.length;
        int firstElement = numbers[0];
        int lastElemnt = numbers[arrLength - 1];
        int firstIndex = 0;
        int lastIndex = arrLength - 1;
        boolean tag = true;
        while (lastIndex - firstIndex > 0) {
            if (firstElement + lastElemnt > target) {
                lastIndex = lastIndex - 1;
                lastElemnt = numbers[lastIndex];
                continue;
            } else if (firstElement + lastElemnt < target) {
                firstIndex = firstIndex + 1;
                firstElement = numbers[firstIndex];
                continue;
            }
            return new int[]{firstIndex + 1, lastIndex + 1};
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (numbers[i] + numbers[m] > target) {
                j = m - 1;
            } else if (numbers[m] + numbers[j] < target) {
                i = m + 1;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }

}
