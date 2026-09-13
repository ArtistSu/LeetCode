package JavaCook;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ArtistS
 * @tag PrefixSum Tree
 * @prb https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(n)
 * @SpaceComplexity O(n)
 */
public class Java_437 {
    /**
     * Brute Force Solution, but time complexity too high it will be O(N^2)
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int pathCount = 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.pollFirst();
            pathCount += findTarget(curr, 0L, targetSum);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        return pathCount;
    }

    public int findTarget(TreeNode root, long prevSum, int targetSum) {
        if (root == null) return 0;
        int count = 0;

        if (root.val + prevSum == targetSum) count++;

        count += findTarget(root.left, root.val + prevSum, targetSum);
        count += findTarget(root.right, root.val + prevSum, targetSum);
        return count;
    }

    /**
     * Google L4 You need to use PrefixSum (Use space to exchange time)
     */
    public int pathSum_google_l4(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Map<Long, Integer> prefixSumTracker = new HashMap<>();
        prefixSumTracker.put(0L, 1);

        return dfs(root, 0L, (long) targetSum, prefixSumTracker);
    }

    public int dfs(TreeNode currentNode, long currentRunningSum, long targetSum, Map<Long, Integer> prefixSumFrequencyMap) {
        if (currentNode == null) return 0;

        currentRunningSum += currentNode.val;
        Long requriedPrefixSum = currentRunningSum - targetSum;
        int pathsEndingAtCurrentNode = prefixSumFrequencyMap.getOrDefault(requriedPrefixSum, 0);

        prefixSumFrequencyMap.put(currentRunningSum, prefixSumFrequencyMap.getOrDefault(currentRunningSum, 0) + 1);

        int totalValidPaths = pathsEndingAtCurrentNode + dfs(currentNode.left, currentRunningSum, targetSum, prefixSumFrequencyMap) + dfs(currentNode.right, currentRunningSum, targetSum, prefixSumFrequencyMap);
        prefixSumFrequencyMap.put(currentRunningSum, prefixSumFrequencyMap.get(currentRunningSum) - 1);

        return totalValidPaths;
    }

    /**
     * Google L5 you need to think about API design
     * "To solve Path Sum III, a brute-force DFS approach would recompute
     * paths from every node, taking $O(N^2)$ time. We can optimize this to $O(N)$ time by leveraging the Prefix Sum
     * technique paired with a hash map.As we traverse down from the root, we track the running sum. At any node, if
     * currentRunningSum - targetSum exists in our history, we know a valid downward path ends at the current node. We
     * also use backtracking to remove entries from the map as we exit a branch so parallel subtrees don't pollute each
     * other.Would you like me to start implementing this $O(N)$ solution?"
     *
     * "I am pre-populating the frequency map with (0L, 1). This handles the base case where a valid path starts directly from the root node itself—since currentRunningSum - targetSum equals 0."
     * "I am casting targetSum and maintaining currentRunningSum as long instead of int. Node values in binary trees can aggregate quickly, so this prevents integer overflow bugs on deep paths."
     * "Notice here after recursing through the left and right subtrees, I am decrementing the frequency. If the count reaches zero, I explicitly remove() the key from the map.This memory pruning ensures our space complexity remains strictly $O(H)$—proportional to the tree height—rather than letting unused zero-frequency keys bloat the hash map in deep trees."
     *
     * "I am encapsulating the prefix sum logic inside a private static final class PrefixSumTracker.
     * First, it decouples the DFS recursion from raw map operations (Separation of Concerns).
     * Second, marking it static ensures it doesn't hold an implicit outer class reference, which eliminates potential memory leaks.
     * Third, it keeps the main DFS method clean, readable, and easy to unit test."
     */
    public int pathSum_google_l5(TreeNode root, int targetSum) {
        if (root == null) return 0;

        PrefixSumTracker prefixSumTracker = new PrefixSumTracker();

        return dfs_google_l5(root, 0L, (long) targetSum, prefixSumTracker);
    }

    public int dfs_google_l5(TreeNode currentNode, long currentRunningSum, long targetSum, PrefixSumTracker prefixSumTracker) {
        if (currentNode == null) return 0;

        currentRunningSum += currentNode.val;
        Long requriedPrefixSum = currentRunningSum - targetSum;
        int pathsEndingAtCurrentNode = prefixSumTracker.getFrequency(requriedPrefixSum);

        prefixSumTracker.incrementFrequency(currentRunningSum);

        int totalValidPaths = pathsEndingAtCurrentNode + dfs_google_l5(currentNode.left, currentRunningSum, targetSum, prefixSumTracker) + dfs_google_l5(currentNode.right, currentRunningSum, targetSum, prefixSumTracker);
        prefixSumTracker.decrementFrequency(currentRunningSum);

        return totalValidPaths;
    }

    public static final class PrefixSumTracker {
        private final Map<Long, Integer> frequencyMap = new HashMap<>();

        public PrefixSumTracker() {
            frequencyMap.put(0L, 1);
        }

        public int getFrequency(long prefixSum) {
            return frequencyMap.getOrDefault(prefixSum, 0);
        }

        public void incrementFrequency(long prefixSum) {
            frequencyMap.put(prefixSum, frequencyMap.getOrDefault(prefixSum, 0) + 1);
        }

        public void decrementFrequency(long prefixSum) {
            int currentFrequency = frequencyMap.getOrDefault(prefixSum, 0);
            if (currentFrequency <= 1) {
                frequencyMap.remove(prefixSum); // To prevent garbage keys from accumulating indefinitely in memory as the tree depth increases.
            } else {
                frequencyMap.put(prefixSum, frequencyMap.getOrDefault(prefixSum, 0) - 1);
            }
        }

    }


}