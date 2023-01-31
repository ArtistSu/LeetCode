package JavaCode;

import java.util.*;
import java.util.stream.Collectors;

public class Java2006 {
    /**
     * BF method
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j< nums.length; j++){
                if(nums[i]-nums[j] == -k || nums[i]-nums[j] == k){
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * Hash
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference2(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            res += cnt.getOrDefault(nums[i]-k,0) + cnt.getOrDefault(nums[i]+k,0);
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
        }
        return res;
    }

    public static List<Integer> cardinalitySort(List<Integer> nums) {

        int[] arr = new int[nums.size()];

        // 1. Get the number of 1
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            int num = nums.get(i);
            while(num != 0){
                if((num&1) == 1){
                    count++;
                }
                num = num >> 1;
            }
            arr[i] = count;
        }

        // 2. Combine array
        int[][] sorted = new int[arr.length][2];

        for(int i = 0; i < arr.length; i++){
            sorted[i][0] = arr[i];
            sorted[i][1] = nums.get(i);
        }

        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        // 3. Output
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            res.add(sorted[i][1]);
        }

        for (int n :
                res) {
            System.out.println(n);
        }

        return res;
    }



    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(31);
        arr.add(8);
        arr.add(7);
        arr.add(3);
        arr.add(2);
        Java2006.cardinalitySort(arr);
    }
 }
