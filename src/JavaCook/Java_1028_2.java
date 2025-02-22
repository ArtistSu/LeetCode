package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Stack
 * @prb https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_1028_2 {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int currentIndex = 0;

        while(currentIndex < traversal.length()){
            int depth = 0;
            while(currentIndex < traversal.length() && traversal.charAt(currentIndex) == '-'){
                depth++;
                currentIndex++;
            }

            // Get Value
            int value = 0;
            while(currentIndex < traversal.length() && Character.isDigit(traversal.charAt(currentIndex))){
                value = value * 10 + (traversal.charAt(currentIndex++) - '0');
            }

            // Create Current Node
            TreeNode node = new TreeNode(value);

            while(stack.size() > depth){
                stack.pop();
            }

            if(!stack.isEmpty()){
                if(stack.peek().left == null){
                    stack.peek().left = node;
                }else{
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while(stack.size() > 1) stack.pop();

        return stack.peek();
    }

    public static void main(String[] args) {
        new Java_1028_2().recoverFromPreorder("1-2--3--4-5--6--7");
    }

}