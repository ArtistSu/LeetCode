package Medium;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/15 11:46 上午
 * Description:
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    int leftOffSet;
    int rightOffSet;

    public  TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
