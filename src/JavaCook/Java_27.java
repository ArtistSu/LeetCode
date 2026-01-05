package JavaCook;

/**
 * @author ArtistS
 * @tag Array TwoPointers
 * @prb https://leetcode.com/problems/remove-element/description/
 * Time complexity: O(n) n is nums.length
 * Space complexity: O(1)
 */
public class Java_27 {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] != val){
                nums[k++] = nums[idx];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        new Java_27().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
}