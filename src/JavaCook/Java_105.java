package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_105 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in Tree
     * @SpaceComplexity O(N)
     */
    public TreeNode buildTree_google_l4(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }


    public TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root index in inorder
        int inRoot = map.get(root.val);

        // Calculate the number of nodes in left sub-tree
        int leftSize = inRoot - inStart;

        root.left = buildSubTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRoot - 1, map);

        root.right = buildSubTree(preorder, preStart + leftSize + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }
}