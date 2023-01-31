package JavaCode;

import java.util.*;

public class Java102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time complexity: O(1) Space Complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        // Result
        List<List<Integer>> resultList = new ArrayList<>();

        TreeNode currNode = root;
        if (currNode == null) {
            return resultList;
        }
        queue.add(currNode);
        while (!queue.isEmpty()) {
            // Store the elements of each level
            List<Integer> partialList = new ArrayList<>();

            // How many elements each level
            int endContion = queue.size();

            for (int i = 0; i < endContion; i++) {
                currNode = queue.poll();
                partialList.add(currNode.val);
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            resultList.add(partialList);

        }
        return resultList;

    }

    public static void main(String[] args) {
        TreeNode t5 = new Java102().new TreeNode(7,null,null);
        TreeNode t4 = new Java102().new TreeNode(15,null,null);
        TreeNode t3 = new Java102().new TreeNode(20,t4,t5);
        TreeNode t2 = new Java102().new TreeNode(9,null,null);
        TreeNode t1 = new Java102().new TreeNode(3,t2,t3);

        new Java102().levelOrder(t1);
    }
}
