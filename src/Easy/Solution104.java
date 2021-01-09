package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/1 1:05 下午
 * Description:
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
