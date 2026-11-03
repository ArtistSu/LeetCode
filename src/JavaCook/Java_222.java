package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb https://leetcode.com/problems/count-complete-tree-nodes/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_222 {
    /**
     * Time complexity: O(N) N is the number of nodes in the tree
     * Space complexity: O(1)
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Time complexity: O(log(N) * log(N)) N is the number of nodes in the tree
     * Space complexity: O(log(N))
     */
    public int countNodes_google_l4(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == rightHeight){
            return (1 << leftHeight) + countNodes(root.right);
        }else{
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int height = 0;

        while(root != null){
            height +=1;
            root = root.left;
        }

        return height;
    }
}