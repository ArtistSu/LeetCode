package java;

public class Java1299 {
    public int[] replaceElements(int[] arr) {
        int maxDigitOfRight = 0;

        // Check for edge cases
        if(arr == null){
            return arr;
        }

        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j] > maxDigitOfRight){
                    maxDigitOfRight = arr[j];
                }
            }
            arr[i] = maxDigitOfRight;
            maxDigitOfRight = 0;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
