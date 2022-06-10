package JavaCode;

public class Java167 {

    /**
     * Time Complexity : O(n) {@code n} is the length of {@param numbers}
     * Space Complexity : O(1)
     * @method Binary Search
     * @topic Two Sum II - Input Array Is Sorted
     * @author ArtistS
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int[] res = new int[]{-1,-1};
        for(int i = 0; i < numbers.length; i++){
            int sub = target - numbers[i];
            int index2 = binarySearch(numbers, sub, i+1);
            if(index2 != -1 && index2 != i){
                res[0] = i + 1;
                res[1] = index2 + 1;
                return res;
            }
        }
        return res;
    }

    public int binarySearch(int[] numbers, int sub, int start){
        int left = start, right = numbers.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(numbers[mid] == sub){
                return mid;
            }
            if(numbers[mid] < sub){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     * Time Complexity : O(n) {@code n} is the length of {@param numbers}
     * Space Complexity : O(1)
     * @method Two Pointers
     * @topic Two Sum II - Input Array Is Sorted
     * @author ArtistS
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
