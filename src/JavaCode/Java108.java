package JavaCode;

import JavaCook.TreeNode;

public class Java108 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(nlogn)
     * @topic Convert Sorted Array to Binary Search Tree
     * @author ArtistS
     * @method recursion
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        return inOrder(nums, 0 , nums.length-1);
    }

    public TreeNode inOrder(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inOrder(nums, left, mid-1);
        root.right= inOrder(nums, mid+1, right);
        return root;
    }
}
