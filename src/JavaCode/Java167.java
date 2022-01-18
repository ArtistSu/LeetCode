package JavaCode;

public class Java167 {
    /**
     * Two pointers
     * Time Conplexity : O(n)
     * Space Complexity : O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int indexA = 0;
        int indexB = numbers.length - 1;
        int[] arr = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int sum = numbers[indexA] + numbers[indexB];
            if (sum == target) {
                arr[0] = indexA + 1;
                arr[1] = indexB + 1;
                return arr;
            }
            if (sum > target) {
                indexB--;
            }
            if (sum < target) {
                indexA++;
            }
        }
        return arr;
    }

    /**
     * BF method
     * Time Complexity : O(n2)
     * Space Complexity : O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        boolean flag = true;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                    flag = false;
                }
                if (!flag) {
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        new Java167().twoSum2(a,9);
    }
}
