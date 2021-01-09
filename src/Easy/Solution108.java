package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/3 2:45 下午
 * Description:
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return this.bstHelper(nums, 0, nums.length - 1);
    }

    public TreeNode bstHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = bstHelper(nums, left, mid - 1);
        root.right = bstHelper(nums, mid + 1, right);
        return root;
    }

}
