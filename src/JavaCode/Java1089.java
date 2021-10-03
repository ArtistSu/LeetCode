package JavaCode;

public class Java1089 {
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
