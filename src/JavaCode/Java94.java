package JavaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Java94 {
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

    List<Integer> resultList = new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();

    // Recursion Time Complexity: O(n) Space Complexity: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return resultList;
        } else {
            st.add(root);
        }

        if (root.left != null) {
            inorderTraversal(root.left);
        } else {
            while (!st.isEmpty()) {
                TreeNode tempNode = st.pop();
                resultList.add(tempNode.val);
                if (tempNode.right != null) {
                    inorderTraversal(tempNode.right);
                }
            }
        }

        return resultList;
    }

    // Iteration Time complexity : O(n) Space Complexity : O(n)
    public List<Integer> inorderTraversal2(TreeNode root) {

        TreeNode currNode = root;
        while(currNode != null || !(st.isEmpty())){
            // Push element into st until the left leaf  node
            if(currNode != null){
                st.push(currNode);
                currNode = currNode.left;
            }else{
                // If the currNode is null, add the prev node. And
                // let currNode equal to the prevNode.right
                resultList.add(st.peek().val);
                currNode = st.pop().right;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode a3 = new Java94().new TreeNode(3, null, null);
        TreeNode a2 = new Java94().new TreeNode(2, a3, null);
        TreeNode a1 = new Java94().new TreeNode(1, null, a2);

        List result = new Java94().inorderTraversal2(a1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));

        }
    }
}
