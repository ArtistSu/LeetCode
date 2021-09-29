package Easy;

import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/1 4:07 下午
 * Description:
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }

}
