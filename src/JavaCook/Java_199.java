package JavaCook;

import java.util.*;

public class Java_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        List<Integer> res = new LinkedList<>();
        int currLevel = 1, nextLevel = 0;

        while (!deque.isEmpty()) {
            while (currLevel > 0) {
                TreeNode currNode = deque.pollFirst();
                if (currLevel == 1) {
                    res.add(currNode.val);
                }
                if (currNode.left != null) {
                    deque.offer(currNode.left);
                    nextLevel++;
                }
                if (currNode.right != null) {
                    deque.offer(currNode.right);
                    nextLevel++;
                }
                currLevel--;
            }
            currLevel = nextLevel;
            nextLevel = 0;
        }
        return res;
    }

    /**
     * Stage 1: "I can think of two approaches to solve this. First, a BFS approach using a queue to traverse level by
     * level, picking the last element of each level. This takes $O(N)$ time and $O(W)$ space, where $W$ is the max
     * width. Second, a DFS approach where we visit right children first. By checking if depth == result.size(), we
     * collect the first node seen at each level. DFS takes $O(H)$ space for the recursion stack. Given that DFS
     * typically uses $O(\log N)$ memory on balanced trees versus $O(N)$ queue memory in BFS, DFS is slightly more
     * memory-efficient here, though both are valid. I’d like to start with the BFS approach—does that sound good to
     * you?"
     * <p>
     * Stage 2: "First, I’ll initialize a result list to store our answers, and use an ArrayDeque as our queue to manage
     * nodes at each level. I’m choosing ArrayDeque over LinkedList due to its contiguous memory allocation and superior
     * cache performance. As I traverse level by level, I'll check if the current node is the last one in the level—if
     * so, I'll append its value to res. Then, if its left or right child is not null, I’ll add them to the queue for
     * the next level. Finally, I’ll return res."
     * <p>
     * Stage 3: Now that the code is complete, let me dry run it with a simple example to verify the logic.
     */
    public List<Integer> rightSideView_google_l5(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();
            for (int i = 0; i < currLevelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == currLevelSize - 1) {
                    res.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

        }
        return res;
    }

    public List<Integer> rightSideView_google_l5_2(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        dfs(root,0,res);

        return res;
    }

    public void dfs(TreeNode node, int depth,List<Integer> res){
        if (node == null) return;

        if(depth == res.size()) res.add(node.val);

        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);

    }

}
