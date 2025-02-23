package JavaCook;

/**
 * @author ArtistS
 * @tag Array HashTable DivideAndConquer Tree BinaryTree
 * @prb https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class Java_889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //pre -> mid left right
        //post -> left right mid
        int len = preorder.length;
        return constructTree(0, len - 1, 0, preorder, postorder);
    }

    public TreeNode constructTree(int preStart, int preEnd, int postStart, int[] preorder, int[] postorder) {
        // Construct tree by pre
        if (preStart > preEnd) return null;

        if (preStart == preEnd) return new TreeNode(preorder[preStart]);

        int leftChildRoot = preorder[preStart + 1];

        int numOfNodesInLeft = 1;
        while (postorder[postStart + numOfNodesInLeft - 1] != leftChildRoot) numOfNodesInLeft++;

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = constructTree(preStart + 1, preStart + numOfNodesInLeft, postStart, preorder, postorder);

        root.right = constructTree(preStart + numOfNodesInLeft + 1, preEnd, postStart + numOfNodesInLeft, preorder, postorder);

        return root;
    }
}