package JavaCode;

import JavaCook.TreeNode;

public class Java654 {
    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Maximum Binary Tree
     * @author ArtistS
     * @method Recursion
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructSub(nums, 0, nums.length - 1);
    }
    public TreeNode constructSub(int[] interval, int left, int right){
        if(left > right){
            return null;
        }
        int maxIdx = left;
        for(int i = left+1; i <= right; i++){
            if(interval[maxIdx] < interval[i]){
                maxIdx=i;
            }
        }
        TreeNode root = new TreeNode(interval[maxIdx]);
        root.left = constructSub(interval, left, maxIdx-1);
        root.right = constructSub(interval, maxIdx+1, right);
        return root;
    }
}
