package JavaCode;

import java.util.Stack;

public class Java1089 {
    public static void main(String[] args) {
        int[] arr = {1,0,2,0,0,1,0,2};
        new Java1089().duplicateZeros2(arr);
    }

    /**
     * Time Complexity: O(n) {@code n} is the length of {@param arr}
     * Space Complexity: O(1)
     * @mthod Simulation
     * @topic Duplicate Zeros
     * @author ArtistS
     * @param arr
     */
    public void duplicateZeros2(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length;i++){
            if(sb.length() == arr.length){
                break;
            }
            sb.append(arr[i]);
            if(arr[i] == 0){
                sb.append(0);
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = sb.charAt(i)-'0';
        }
    }
    public void duplicateZeros(int[] arr) {
        int arrLength = arr.length;
        int breakpoint = 0;

        for (int currIndex = 0; currIndex < arrLength; currIndex++) {
            if (arr[currIndex] == 0) {
                for (int shiftIndex = arrLength - 1; shiftIndex >= currIndex + 1; shiftIndex--) {
                    arr[shiftIndex] = arr[shiftIndex - 1];
                }
                if (currIndex + 1 < arrLength) {
                    arr[currIndex + 1] = 0;
                    currIndex += 1;
                }

            }
        }
    }
}
