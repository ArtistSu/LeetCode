package JavaCode;

public class Java941 {
    public boolean validMountainArray(int[] arr) {

        int length = arr.length;
        int i = 0;

        while (i + 1 < length && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == length) {
            return false;
        }

        while (i + 1 < length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == length;

    }
}
