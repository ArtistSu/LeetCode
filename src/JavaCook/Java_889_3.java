package JavaCook;

/**
 * @author ArtistS
 * @tag Array HashTable DivideAndConquer Tree BinaryTree
 * @prb https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_889_3 {
    private int preIndex = 0;
    private int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    // Helper function to recursively build the tree
    private TreeNode constructTree(int[] preorder, int[] postorder) {
        // Create a new node with the value at the current preorder index
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Recursively construct the left subtree if the root is not the last of
        // its subtree
        if (root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }

        // Recursively construct the right subtree if the root is still not the
        // last of its subtree
        if (root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }

        // Mark this node and its subtree as fully processed
        postIndex++;
        return root;
    }
}