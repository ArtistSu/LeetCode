package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_450{
    public TreeNode deleteNode_google_l5(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode_google_l5(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode_google_l5(root.right, key);
            return root;
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode successorParent = root;
            TreeNode successor = root.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (successorParent != root) {
                successorParent.left = successor.right;
                successor.right = root.right;
            }
            successor.left = root.left;

            return successor;
        }
    }
}