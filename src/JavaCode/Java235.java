package JavaCode;

public class Java235 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Lowest Common Ancestor of a Binary Search Tree
     * @author ArtistS
     * @method Traverse
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(true){
            if(p.val < ancestor.val && q.val < ancestor.val){
                ancestor = ancestor.left;
            }else if(p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }
}
