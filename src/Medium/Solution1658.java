package Medium;

import javax.swing.event.TreeExpansionListener;
import java.util.*;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/15 10:22 上午
 * Description:
 */
public class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int i = 0;
        int j = nums.length - 1;
        int step = 0;
        //1. 设置根节点
        TreeNode root = new TreeNode(x);
        root.leftOffSet = -1;
        root.rightOffSet = -1;
        TreeNode curr = root;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        //2. 遍历
        while (!treeNodes.isEmpty()) {
            if (i < j) {
                curr.left = new TreeNode(x - nums[i]);
                curr.left.leftOffSet = curr.leftOffSet + 1;
                curr.left.rightOffSet = curr.rightOffSet + 1;
                if (curr.left.val <= 0 || curr.right.val <= 0) {
                    return step;
                }
                treeNodes.offer(curr.left);
                i += 1;
                step += 1;
                curr = curr.left;
            }

        }
        return 0 ;
    }


}

