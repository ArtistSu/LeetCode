package JavaCode;

import JavaCook.TreeNode;

import java.util.*;

public class Java508 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes under {@prams root} (include root)
     * Space Complexity: O(n)
     * @method DFS
     * @topic Most Frequent Subtree Sum
     * @author ArtistS
     * @param root
     * @return
     */
    Map<Integer, Integer> records = new HashMap<>();
    int maxFreqency = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root);
        // for(int key: records.keySet()
        for (Map.Entry<Integer, Integer> entry : records.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (val == maxFreqency) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int sum = left + right + root.val;
        record(sum);
        return sum;
    }

    public void record(int sum) {
        // records.put(sum, record.getOrDefault(sum,0)+1)
        if (records.containsKey(sum)) {
            int fre = records.get(sum);
            records.put(sum, fre + 1);
        } else {
            records.put(sum, 1);
        }
        maxFreqency = Math.max(maxFreqency, records.get(sum));
    }
}
