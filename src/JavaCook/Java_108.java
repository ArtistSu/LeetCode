package JavaCook;

/**
 * @author ArtistS
 * @tag Recursion BST
 * @prb https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_108{
    /**
     * Time complexity: O(N) N is the length of Array nums
     * Space complexity: O(H) H is the log(N)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstHelper(nums,0,nums.length-1);
    }

    public TreeNode bstHelper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int rootIdx = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = bstHelper(nums,start,rootIdx-1);
        root.right = bstHelper(nums,rootIdx+1,end);

        return root;
    }

}