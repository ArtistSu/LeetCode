package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch
 * @prb https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class Java_167{
    public int[] twoSum(int[] numbers, int target) {
        int idx = 0;
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int num1 = numbers[i];
            idx = find2Num(numbers, target-numbers[i]);
            if(idx != -1){
                res[0] = i;
                res[1] = idx;
                return res;
            }
        }
        return res;
    }

    public int find2Num(int[] numbers, int gap){
        int left = 0;
        int right = numbers.length - 1;
        int mid = left + (right - left)/2;

        while(left < right){
            if(gap == numbers[mid]){
                return mid;
            }else if(numbers[mid] < gap){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}