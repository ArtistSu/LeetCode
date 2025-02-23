package JavaCook;

/**
 * @author ArtistS
 * @tag Array HashTable DivideAndConquer Tree BinaryTree
 * @prb https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_889_2 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //pre -> mid left right
        //post -> left right mid
        int len = preorder.length;
        int[] indexInPostorder = new int[len + 1];
        for (int index = 0; index < len; index++) {
            indexInPostorder[postorder[index]] = index;
        }
        return constructTree(0, len - 1, 0, preorder, indexInPostorder);
    }

    public TreeNode constructTree(int preStart, int preEnd, int postStart, int[] preorder, int[] indexInPostOrder) {
        // Construct tree by pre
        if (preStart > preEnd) return null;

        if (preStart == preEnd) return new TreeNode(preorder[preStart]);

        int leftChildRoot = preorder[preStart + 1];

        int numOfNodesInLeft = indexInPostOrder[leftChildRoot] - postStart + 1;

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = constructTree(preStart + 1, preStart + numOfNodesInLeft, postStart, preorder, indexInPostOrder);

        root.right = constructTree(preStart + numOfNodesInLeft + 1, preEnd, postStart + numOfNodesInLeft, preorder, indexInPostOrder);

        return root;
    }
}