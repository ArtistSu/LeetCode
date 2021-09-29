package java;

public class java1295 {
    public int findNumbers(int[] nums) {
        int evenNumber = 0;
        int number = 0;
        for (int currNumber :
                nums) {
            if (String.valueOf(currNumber).toCharArray().length % 2 == 0){
                number ++;
            }
        }
        return number;
    }
}
