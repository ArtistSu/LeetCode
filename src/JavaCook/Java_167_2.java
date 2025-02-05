package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch
 * @prb https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_167_2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            }else if (sum > target) {
                right--;
            }else{
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}