

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-13 12:41
 * @Description Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input
 * array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new
 * length.
 */
public class Solution27 {
    //TimeComplexity:O(n)
    //TimeComplexity:O(1)
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int key = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == val){
                continue;
            }else{
                nums[key]=nums[i];
                key++;
            }
        }
        return key;
    }
}
