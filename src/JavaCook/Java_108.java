package JavaCook;

/**
 * @author ArtistS
 * @tag Recursion BST
 * @prb https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_108{
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstHelper(nums,0,nums.length-1);
    }

    public TreeNode bstHelper(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bstHelper(nums,left,mid-1);
        root.right = bstHelper(nums,mid+1,right);
        return root;
    }
}