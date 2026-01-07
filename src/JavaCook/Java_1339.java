package JavaCook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ArtistS
 * @tag Tree BFS BinaryTree
 * @prb https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_1339 {
    public int maxProduct(TreeNode root) {
        long mod = 1000000007;
        long ans = 0;
        long total = dfs(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            long currAns = (total - node.val) * node.val;
            ans = Math.max(ans, currAns);

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return (int)(ans % mod);

    }

    public long dfs(TreeNode node){
        if (node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }
}
