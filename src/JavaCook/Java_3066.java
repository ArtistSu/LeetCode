package JavaCook;

import java.util.PriorityQueue;

/**
 * @author ArtistS
 * @tag Array Simulation PriorityQueue
 * @prb https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
public class Java_3066{
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue();
        for(long num : nums){
            if(num < k) pq.add(num);
        }
        int res = 0;
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                pq.poll();
            }else{
                long num1 = pq.poll();
                long num2 = pq.poll();
                long temp = Math.min(num1, num2)*2 + Math.max(num1, num2);
                if(temp < k){
                    pq.add(temp);
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Java_3066().minOperations(new int[]{999999999,999999999,999999999}, 1000000000);
    }
}