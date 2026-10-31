package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_106{
    /**
     * @TimeComplexity O(N) N is number of nodes in Tree
     * @SpaceComplexity O(N)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return buildSubTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }

    public TreeNode buildSubTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd, Map<Integer,Integer> map){
        if(poStart > poEnd) return null;

        int rootVal = postorder[poEnd];
        int rootIdx = map.get(rootVal);
        int leftSize = rootIdx - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildSubTree(inorder,inStart,rootIdx-1,postorder,poStart,poStart+leftSize-1,map);
        root.right = buildSubTree(inorder,rootIdx+1,inEnd,postorder,poStart+leftSize,poEnd-1,map);

        return root;
    }
}