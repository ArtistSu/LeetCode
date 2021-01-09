package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/5 10:35 上午
 * Description:
 */
public class Solution111 {
    //DFS
    public int minDepth(TreeNode root) {
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if(root.left == null || root.right == null) return Math.max(m1, m2) + 1;
        return Math.min(m1, m2) + 1;
    }

}
