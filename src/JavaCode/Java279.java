package JavaCode;

import java.util.*;

public class Java279 {
    /**
     * Dynamic Programming(DP)
     * Time Complexity : O(n * sqrt(n))
     * Space Complexity : O(n+1)
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            int min = dp[i];
            for (int j = 1; j * j <= i  ; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
    /**
     * Title : Perfect Squares
     * Breadth-first-search (BFS)
     * Time Complexity : O(n * sqrt(n))
     * Space Complexity : O(n)
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        //记录访问过的节点值
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        //树的第几层
        int level = 0;
        while (!queue.isEmpty()) {
            //每一层的节点数量
            int size = queue.size();
            level++;
            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                //节点的值
                int digit = queue.poll();
                //访问当前节点的子节点，类比于二叉树的左右子节点
                for (int j = 1; j <= n; j++) {
                    //子节点的值
                    int nodeValue = digit + j * j;
                    //nodeValue始终是完全平方数的和，当他等于n的
                    //时候直接返回
                    if (nodeValue == n)
                        return level;
                    //如果大于n，终止内层循环
                    if (nodeValue > n)
                        break;
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }
}
