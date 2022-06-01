package JavaCode;

public class Java450 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes in {@param root}
     * Space Complexity: O(n)
     * @method recursion
     * @topic Delete Node in a BST
     * @author ArtistS
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            if(root.right != null){
                TreeNode temp = root.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                root.right = deleteNode(root.right, temp.val);
                temp.right = root.right;
                temp.left = root.left;
                return temp;
            }
        }
        return root;
    }
}
