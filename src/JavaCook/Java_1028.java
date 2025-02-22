package JavaCook;

/**
 * @author ArtistS
 * @tag String Tree DFS BinaryTree
 * @prb https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_1028{
    int currentIndex = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal,0);
    }

    public TreeNode helper(String traversal, int depth){
        if(currentIndex >= traversal.length()) return null;

        // Count for dash
        int count = 0;
        while((currentIndex+count) < traversal.length() && traversal.charAt(currentIndex+count) == '-') count++;

        if(count != depth) return null;

        currentIndex = currentIndex + count;

        // Node value
        int value = 0;
        while(currentIndex < traversal.length() && Character.isDigit(traversal.charAt(currentIndex))){
            value = value * 10 + (traversal.charAt(currentIndex++) - '0');
        }

        TreeNode node = new TreeNode(value);
        node.left = helper(traversal,depth+1);
        node.right = helper(traversal,depth+1);

        return node;
    }
}