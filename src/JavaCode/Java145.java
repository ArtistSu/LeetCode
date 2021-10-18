package JavaCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java145 {
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
    LinkedList<Integer> resultList2 = new LinkedList<>();
    Stack<TreeNode> st = new Stack();

    // Recursion Time Complexity: O(n)  Space Complexity:O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode currNode = root;
        if (currNode == null) {
            return resultList;
        }
        postorderTraversal(currNode.left);
        postorderTraversal(currNode.right);
        resultList.add(currNode.val);

        return resultList;
    }

    // Iteration Time Complexity: O(n) Space Complexity: O(n)
    public List<Integer> postorderTraversal2(TreeNode root) {
        TreeNode currNode = root;
        if (currNode == null) {
            return resultList2;
        }
        st.push(currNode);
        while (!st.isEmpty()) {
            currNode = st.pop();
            resultList2.addFirst(currNode.val);
            if (currNode.left != null) {
                st.push(currNode.left);
            }
            if (currNode.right != null) {
                st.push(currNode.right);
            }
        }
        return resultList2;
    }

    public static void main(String[] args) {
        TreeNode a3 = new Java145().new TreeNode(2, null, null);
        TreeNode a2 = new Java145().new TreeNode(1, null, null);
        TreeNode a1 = new Java145().new TreeNode(3, a2, a3);

        List result = new Java145().postorderTraversal2(a1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));

        }
    }

}
