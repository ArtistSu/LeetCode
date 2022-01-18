package JavaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Java144 {
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

    // Recursive Time Complexity: O(n) Space Complexity: O(n)
    Stack<TreeNode> st = new Stack<>();
    List<Integer> resultList = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            resultList.add(root.val);
            st.add(root);
        } else {
            return resultList;
        }

        if (root.left != null) {
            preorderTraversal(root.left);
        } else {
            while (!st.isEmpty()) {
                TreeNode temp = st.pop();
                if (temp.right != null) {
                    preorderTraversal(temp.right);
                }
            }
        }
        return resultList;
    }

    // Iterative Time Complexity: O(n) Space Complexity: O(n)
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return resultList;
        } else {
            st.push(root);
        }

        while (!st.isEmpty()) {
            TreeNode tempNode = st.pop();
            resultList.add(tempNode.val);

            if (tempNode.right != null) {
                st.push(tempNode.right);
            }

            if (tempNode.left != null) {
                st.push(tempNode.left);
            }
        }
        return resultList;
    }

    public List<Integer> preorderTraversalEx(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> resultList = new ArrayList<>();

            if (root == null) {
                return resultList;
            }

            st.push(root);

            while (!st.isEmpty()) {
                TreeNode tempNode = st.pop();
                resultList.add(tempNode.val);

                if (tempNode.right != null) {
                    st.push(tempNode.right);
                }
                if (tempNode.left != null) {
                    st.push(tempNode.left);
                }
            }
            return resultList;
        }



}
