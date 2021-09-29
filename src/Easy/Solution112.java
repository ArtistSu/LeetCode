package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/6 10:49 上午
 * Description:
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

