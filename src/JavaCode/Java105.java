package JavaCode;

import JavaCook.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Java105 {
    int preIdx = 0;
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> valIdx = new HashMap<>();

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = preOrder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = valIdx.get(rootVal);

        preIdx++;
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index - 1);


        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;

        int idx = 0;
        for (Integer val :
                inOrder) {
            valIdx.put(val, idx++);
        }

        return helper(0, inOrder.length - 1);
    }

    public static void main(String[] args) {
        int [] inorder = {3,9,20};
        int [] preorder = {9,3,20};

        new Java105().buildTree(inorder, preorder);
    }
}
