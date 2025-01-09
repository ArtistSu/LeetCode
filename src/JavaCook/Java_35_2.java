package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb Time complexity:
 * Space complexity:
 */
public class Java_35_2 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }

        return start == 0 ? 0 : nums.length+1;
    }
}