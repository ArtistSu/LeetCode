package JavaCode;

public class Java1051 {
    public int heightChecker(int[] heights) {
        int resultNumber = 0;
        int[] arryCopy = heights.clone();

        // sort the arrCopy
        for (int i = 1; i < arryCopy.length; i++) {
            for (int j = 0; j < arryCopy.length - i;j++) {
                if(arryCopy[j] > arryCopy[j + 1]){
                    int temp = arryCopy[j];
                    arryCopy[j] = arryCopy[j + 1];
                    arryCopy[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != arryCopy[i]){
                resultNumber++;
            }
        }
        return resultNumber;
    }
}
