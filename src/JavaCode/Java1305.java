package JavaCode;

import JavaCook.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java1305 {
    /**
     * Time Complexity : O(n + m) n is the size of @elementsA m is the size of @elementsB
     * Space Complexity: O(n + m)
     * @method inorder + merged method
     * @topic All Elements in Two Binary Search Trees
     * @author ArtistS
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> elementsA = new ArrayList<>();
        List<Integer> elementsB = new ArrayList<>();
        inorder(root1, elementsA);
        inorder(root2, elementsB);

        List<Integer> merged = new ArrayList<>();
        int ptrA = 0, ptrB = 0;
        while(true){
            if(ptrA == elementsA.size()){
                merged.addAll(elementsB.subList(ptrB, elementsB.size()));
                break;
            }
            if(ptrB == elementsB.size()){
                merged.addAll(elementsA.subList(ptrA, elementsA.size()));
                break;
            }
            if(elementsA.get(ptrA) < elementsB.get(ptrB)){
                merged.add(elementsA.get(ptrA));
                ptrA++;
            }else{
                merged.add(elementsB.get(ptrB));
                ptrB++;
            }
        }
        return merged;
    }

    public void inorder(TreeNode currNode, List<Integer> elements){
        if(currNode == null){
            return ;
        }
        inorder(currNode.left, elements);
        elements.add(currNode.val);
        inorder(currNode.right, elements);
    }
    /**
     * Time Complexity : O(n + log n)
     * Space Complexity: O(n)
     * @method BF method
     * @topic All Elements in Two Binary Search Trees
     * @author ArtistS
     * @param root1
     * @param root2
     * @return
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        addElement(root1);
        addElement(root2);
        Collections.sort(res);
        return res;
    }

    public void addElement(TreeNode currNode){
        if(currNode != null){
            res.add(currNode.val);
            addElement(currNode.left);
            addElement(currNode.right);
        }
    }
}
