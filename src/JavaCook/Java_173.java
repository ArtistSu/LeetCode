package JavaCook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_173{

    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(N)
     */
    class BSTIterator {

        private int pointer;
        private final List<TreeNode> inorder;

        public BSTIterator(TreeNode root) {
            this.pointer = 0;
            this.inorder = new ArrayList<>();

            // Inorder
            inOrder(root);
        }

        public int next() {
            return inorder.get(pointer++).val;
        }

        public boolean hasNext() {
            return pointer == inorder.size() ? false : true;
        }

        public void inOrder(TreeNode root){
            if(root == null) return ;

            inOrder(root.left);
            inorder.add(root);
            inOrder(root.right);
        }
    }

    /**
     * @TimeComplexity O(1)
     * @SpaceComplexity O(log(H)) H is the height of the tree
     */
    class BSTIterator_google_l4 {

        private Deque<TreeNode> stack;

        public BSTIterator_google_l4(TreeNode root) {
            this.stack = new ArrayDeque<>();

            // Put the left subtree of the root node to the stack
            leftMostInorder(root);
        }

        private void leftMostInorder(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();

            if(node.right != null){
                leftMostInorder(node.right);
            }

            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

    }
}